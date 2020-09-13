package com.wsw.wswclient1.entity;

/**
 * @Author WangSongWen
 * @Date 2020/9/13 下午8:41
 * @Description:
 */
public class Meta {
    private Boolean keepAlive;
    private Boolean requireAuth;

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
