//package com.github.huhangchn.security;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class WebSecurityCfg extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .exceptionHandling()
//                .accessDeniedHandler(new GoAccessDeniedHandler())
//                .authenticationEntryPoint(new GoAuthenticationEntryPoint())
//                .and().authorizeRequests()
//                .antMatchers("/**").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .successHandler(new GoAuthenticationSuccessHandler())
//                .failureHandler(new GoAuthenticationFailureHandler())
//                .and().logout()
//                .logoutUrl("/logout")
//                .logoutSuccessHandler(new GoLogoutSuccessHandler())
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .and().requiresChannel()
//                .antMatchers("/pomer").requiresSecure()
//                .anyRequest().requiresInsecure()
//                .and().rememberMe()
//                .tokenValiditySeconds(1800)
//                .key("token_key");
//    }
//}
