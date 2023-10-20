package org.abstruck;

public record OssInfo(
        String bucket,
        String endpoint,
        String region,
        String accessKeyId,
        String accessKeySecret,
        String securityToken) {
    /**
     * strategy	String
     * appId	Object
     * bucket	String
     * endpoint	String
     * region	String
     * accessKeyId	String
     * accessKeySecret	String
     * securityToken	String
     * expiration	String
     */
}
