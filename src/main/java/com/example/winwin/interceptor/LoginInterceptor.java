package com.example.winwin.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userNumber = request.getSession().getAttribute("userNumber");

        if(userNumber == null){
            request.setAttribute("checkLogin", false);
            response.sendRedirect("/main/main");
//            이전 페이지로 이동 어캐 함?
            return false;
        }

        return true;
    }
}
