package com.huaisui.configuration;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String id = (String) request.getSession().getAttribute("userid");
        if (id == null){
            response.sendRedirect("/login");
            return false;
        }else {
            return true;
        }
    }
}
