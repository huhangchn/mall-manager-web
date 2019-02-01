//package com.github.huhangchn.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;
//import lombok.experimental.Accessors;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import java.util.Collection;
//import java.util.List;a
//
//@Data
//@Accessors(chain = true)
//public class User2 implements UserDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    /**
//     * 用户名
//     */
//    private String username;
//
//    /**
//     * 密码
//     */
//    @JsonIgnore
//    private String password;
//
//    /**
//     * 昵称
//     */
//    private String nickname;
//
//    /**
//     * 0 男， 1女
//     */
//    private String gender;
//
//    /**
//     * 联系方式
//     */
//    private String mobile;
//
//    /**
//     * 头像
//     */
//    @Column(name = "avatar_url")
//    private String avatarUrl;
//
//    /**
//     * 用户状态("0", "Active"), ("1", "Inactive"), ("1", "Cancelled");
//     */
//    private String status;
//
//    /**
//     * 权限
//     */
//    private List<? extends GrantedAuthority> authorities;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}