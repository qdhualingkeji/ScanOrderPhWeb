package com.qdhualing.app.vo;

import java.util.Date;


/**
 * SumictAdmin entity. @author MyEclipse Persistence Tools
 */

public class SumictAdmin  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String userName;
     private String password;
     private Date loginTime;
     private Date lastLoginTime;
     private String ip;
     private String roles;


    // Constructors

    /** default constructor */
    public SumictAdmin() {
    }

    
    /** full constructor */
    public SumictAdmin(String userName, String password, Date loginTime, Date lastLoginTime, String ip, String roles) {
        this.userName = userName;
        this.password = password;
        this.loginTime = loginTime;
        this.lastLoginTime = lastLoginTime;
        this.ip = ip;
        this.roles = roles;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLoginTime() {
        return this.loginTime;
    }
    
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLastLoginTime() {
        return this.lastLoginTime;
    }
    
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRoles() {
        return this.roles;
    }
    
    public void setRoles(String roles) {
        this.roles = roles;
    }
   








}