package kr.ac.kopo.interceptor;

import kr.ac.kopo.model.Member;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class interceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception{
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");

        if(member != null){
            return true;
        }

        String query = request.getQueryString();
        session.setAttribute("target_url", request.getRequestURI() + (query != null ? "?" + query : ""));

        response.sendRedirect("/login");
        return false;
    }

}
