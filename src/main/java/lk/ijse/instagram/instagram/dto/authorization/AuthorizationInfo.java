package lk.ijse.instagram.instagram.dto.authorization;


import lk.ijse.instagram.instagram.constant.Permissions;

import java.util.List;

public class AuthorizationInfo {

    private String accessToken;
    private String expireTime;
//    private String userImageUrl;
    private List<Permissions> permissions;

//    public String getUserImageUrl() {
//        return userImageUrl;
//    }
//
//    public void setUserImageUrl(String userImageUrl) {
//        this.userImageUrl = userImageUrl;
//    }

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }
}
