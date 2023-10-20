package org.abstruck;

public record CommonResponse<T>(T result,String targetUrl,Boolean success,Object error,Boolean unAuthorizedRequest) {
}
