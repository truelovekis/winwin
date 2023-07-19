package com.example.winwin.interceptor;

import com.example.winwin.service.myPage.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class MyPageInterceptor implements HandlerInterceptor {
    private final MyPageService myPageService;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        req.setAttribute("sideBar", myPageService.getSideBar(userNumber));

        return true;
    }
}
