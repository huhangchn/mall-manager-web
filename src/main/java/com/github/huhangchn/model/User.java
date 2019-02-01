package com.github.huhangchn.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Data
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @JsonIgnoreProperties(allowSetters = true)
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 0 男， 1女
     */
    private String gender;

    /**
     * 联系方式
     */
    private String mobile;

    /**
     * 头像
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 用户状态("0", "Active"), ("1", "Inactive"), ("1", "Cancelled");
     */
    private String status;

    /**
     * 注册时间
     */
    private Date createTime;

}