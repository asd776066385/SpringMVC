package com.base.model;

import java.io.Serializable;
import java.util.Date;

public class UserVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7963077386962859307L;
	
	private String userId;
    private String userName;
    private String userPasss;
    private String actor;
    private Date cteatedTime;
    private Date modifyedTime;
    private String description;
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasss() {
        return userPasss;
    }

    public void setUserPasss(String userPasss) {
        this.userPasss = userPasss;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Date getCteatedTime() {
        return cteatedTime;
    }

    public void setCteatedTime(Date cteatedTime) {
        this.cteatedTime = cteatedTime;
    }

    public Date getModifyedTime() {
        return modifyedTime;
    }

    public void setModifyedTime(Date modifyedTime) {
        this.modifyedTime = modifyedTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPasss='" + userPasss + '\'' +
                ", actor='" + actor + '\'' +
                ", cteatedTime=" + cteatedTime +
                ", modifyedTime=" + modifyedTime +
                ", description='" + description + '\'' +
                '}';
    }
}