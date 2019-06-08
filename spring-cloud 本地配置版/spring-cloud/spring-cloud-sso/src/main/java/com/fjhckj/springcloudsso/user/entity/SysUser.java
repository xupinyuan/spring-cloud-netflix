package com.fjhckj.springcloudsso.user.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "spring_cloud.sys_user")
public class SysUser implements Serializable {
    private static final long serialVersionUID = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}