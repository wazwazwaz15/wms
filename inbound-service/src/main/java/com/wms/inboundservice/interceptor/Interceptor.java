package com.wms.inboundservice.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();

        request.setAttribute("startTime", startTime);
        System.out.println("[Request] 的請求方法: " + request.getMethod()+" "
                + " |  URL :"+request.getRequestURI());

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        long startTime = (long) request.getAttribute("startTime");

        long duration = System.currentTimeMillis() - startTime;


        System.out.println("[Response] " + request.getMethod() + " " + request.getRequestURI()
                + " | Status: " + response.getStatus()
                + " | Time: " + duration + " ms"
        );



    }
}
