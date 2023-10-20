package org.abstruck;

public record UserInfo(String clientCode,String accessToken,Object rongCloudToken,Integer expireInSeconds,Integer userId,Integer roleType,
                       String mobile, Boolean needChangePwd,String refreshToken) {

    /**
     * "clientCode": "",
     *         "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjI4MTAwIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6IjIyd2FuZ3pob25ncGVuZyIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvcm9sZSI6IlN0dWRlbnQiLCJzdWIiOiIyODEwMCIsImp0aSI6ImI2YjI4YjBjLWQ3ZGUtNDYzNi1iNWUzLWMzZDA4OGY2ZDFkMiIsImlhdCI6MTY5NzE4NTUxNCwibmJmIjoxNjk3MTg1NTE0LCJleHAiOjE2OTcxOTI3MTQsImlzcyI6IkV6eSIsImF1ZCI6IlNYWiJ9.yXZ0ydgZZqpJqvkR4ineqRvWr9_tprELk8Kvi-pnwoI",
     *         "rongCloudToken": null,
     *         "expireInSeconds": 7200,
     *         "userId": 28100,
     *         "roleType": 1,
     *         "mobile": null,
     *         "needChangePwd": false,
     *         "refreshToken": "0ae80e1a3f9e41b49e0bd7d493bac690",
     *         "refreshExpireInSeconds": 604800,
     *         "needSmsVerification": false
     */
}
