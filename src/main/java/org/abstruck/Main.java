package org.abstruck;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.common.auth.DefaultCredentials;
import com.aliyun.oss.common.auth.STSKeyPairSessionCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyuncs.auth.KeyPairCredentials;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("上传路径");
        String key = sb.readLine();
        System.out.println("文件路径");
        String path = sb.readLine();

        OkHttpClient client = new OkHttpClient();
        String loginUrl = "http://sxz.api6.zykj.org/api/TokenAuth/Login";

        var loginInfo = new LoginInfo("22yangqian","123456",1);
        Request request = new Request.Builder()
                .url(loginUrl)
                .post(RequestBody.create(
                        new Gson().toJson(loginInfo), MediaType.parse("application/json")))
                .build();

        UserInfo info = null;
        try (Response resp = client.newCall(request).execute()){
            String data = resp.body().string();
            CommonResponse<UserInfo> response = new Gson().fromJson(data, new TypeToken<CommonResponse<UserInfo>>() {}.getType());
            info = response.result();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (info==null) return;

        //shit code

        String ossUrl = "http://sxz.api6.zykj.org/api/services/app/ObjectStorage/GeneratorTokenAsync";

        Request req2 = new Request.Builder()
                .get()
                .url(ossUrl)
                .addHeader("Authorization", "Bearer %s".formatted(info.accessToken()))
                .addHeader("AppName","com.zykj.mistake")
                .addHeader("AppVersion","205")
                .build();

        OssInfo ossInfo = null;

        try (Response resp = client.newCall(req2).execute()) {
            String data = resp.body().string();
            CommonResponse<OssInfo> response = new Gson().fromJson(data, new TypeToken<CommonResponse<OssInfo>>() {}.getType());
            ossInfo = response.result();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (ossInfo == null) return;
        //the value provided by zykj is wrong. replace
        OSS oss = new OSSClientBuilder().build("http://oss-cn-hangzhou.aliyuncs.com", ossInfo.accessKeyId(), ossInfo.accessKeySecret(), ossInfo.securityToken());
        oss.putObject(new PutObjectRequest(ossInfo.bucket(),key,new File(path)));
        System.out.println("done");
    }
}