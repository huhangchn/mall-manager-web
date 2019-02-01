//package com.github.huhangchn.configurer;
//
//
//import com.github.huhangchn.security.UrlUserService;
//import com.github.huhangchn.util.MD5Util;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.session.SessionRegistry;
//import org.springframework.security.core.session.SessionRegistryImpl;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//
////@Configuration
////@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UrlUserService urlUserService;
//    @Autowired
//    SessionRegistry sessionRegistry;
//
//    @Override
//    public void configure(WebSecurity web) {
////        web.ignoring(). antMatchers("/swagger-ui.html")
////                .antMatchers("/webjars/**")
////                .antMatchers("/v2/**")
////                .antMatchers("/swagger-resources/**")
////                .antMatchers("/images/**")
////                .antMatchers("/js/**")
////                .antMatchers("/css/**")
////                .antMatchers("/fonts/**")
////                .antMatchers("/favicon.ico");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/swagger-ui.html").permitAll()
//                .antMatchers("/webjars/**").permitAll()
//                .antMatchers("/v2/**").permitAll()
//                .antMatchers("/swagger-resources/**").permitAll()
//                .antMatchers("/images/**").permitAll()
//                .antMatchers("/js/**").permitAll()
//                .antMatchers("/css/**").permitAll()
//                .antMatchers("/fonts/**").permitAll()
//                .antMatchers("/favicon.ico").permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/logout").permitAll()
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry)
//                .and()
//                .and()
//                .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .and()
//                .httpBasic();
//        http.formLogin();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(urlUserService).passwordEncoder(new PasswordEncoder() {
//
//            @Override
//            public String encode(CharSequence rawPassword) {
//                return MD5Util.encode((String) rawPassword);
//            }
//
//            @Override
//            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                return encodedPassword.equals(MD5Util.encode((String) rawPassword));
//            }
//        });
//    }
//
//    @Bean
//    public SessionRegistry getSessionRegistry() {
//        return new SessionRegistryImpl();
//    }
//}