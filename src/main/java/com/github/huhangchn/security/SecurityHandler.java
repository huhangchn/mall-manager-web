//package com.github.huhangchn.security;
//
//import com.alibaba.fastjson.JSON;
//import com.github.huhangchn.result.CodeMsg;
//import com.github.huhangchn.result.ResultFactory;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//class GoAccessDeniedHandler implements AccessDeniedHandler {
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response,
//                       AccessDeniedException exception) throws IOException {
//        response.setHeader("Content-Type", "application/json;charset=utf-8");
//        response.getWriter().print(JSON.toJSONString(ResultFactory.error(CodeMsg.ACCESS_DENIED)));
//        response.getWriter().flush();
//    }
//}
//
//class GoAuthenticationEntryPoint implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response,
//                         AuthenticationException exception) throws IOException {
//        response.setHeader("Content-Type", "application/json;charset=utf-8");
//        response.getWriter().print(JSON.toJSONString(ResultFactory.error(CodeMsg.NOT_FOUND)));
//        response.getWriter().flush();
//    }
//}
//
//class GoAuthenticationFailureHandler implements AuthenticationFailureHandler {
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//                                        AuthenticationException exception) throws IOException, ServletException {
//        response.setHeader("Content-Type", "application/json;charset=utf-8");
//        response.getWriter().print(JSON.toJSONString(ResultFactory.error(CodeMsg.AUTH_FAILED)));
//        response.getWriter().flush();
//    }
//}
//
//class GoAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws IOException, ServletException {
//        response.setHeader("Content-Type", "application/json;charset=utf-8");
//        response.getWriter().print(ResultFactory.success("登录成功"));
//        response.getWriter().flush();
//    }
//}
//
//class GoLogoutSuccessHandler implements LogoutSuccessHandler {
//
//    @Override
//    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
//                                Authentication authentication) throws IOException, ServletException {
//        response.setHeader("Content-Type", "application/json;charset=utf-8");
//        response.getWriter().print(ResultFactory.success("注销成功"));
//        response.getWriter().flush();
//    }
//}
