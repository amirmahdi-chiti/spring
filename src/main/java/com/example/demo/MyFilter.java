//package com.example.demo;
//
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import java.io.IOException;
//
//@Component
//@Order(1)
//public class MyFilter implements Filter{
//
//    @Override
//    public void doFilter(ServletRequest servletRequest,
//                         ServletResponse servletResponse,
//                         FilterChain filterChain) throws IOException, ServletException {
//        String name = servletRequest.getParameter("name");
//        if(name.equals("amirmahdi")){
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//        else{
//            return;
//        }
//    }
//}
