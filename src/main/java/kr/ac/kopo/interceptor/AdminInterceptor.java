package kr.ac.kopo.interceptor;

import kr.ac.kopo.model.Member;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;


public class AdminInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Member sessionMember = (Member) request.getSession().getAttribute("member");
        Optional<Member> optionalMember = Optional.ofNullable(sessionMember);
        //세션값이 null이 아니면
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            //아이디가 admin 이면
            if(member.getId().equals("admin")){
                return true;
            //아이디가 admin이 아니면
            }else {
                response.sendRedirect("/");
                return false;
            }
        } else {
            response.sendRedirect("/login");
            return false;
        }
    }

}


//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        Member member = (Member)request.getSession().getAttribute("member");
//        Optional<Member> optionalMember = Optional.ofNullable(member);
//
//        if(optionalMember.isPresent()){
//            Member member1 = optionalMember.get();
//
//            if (member1.getId().equals("admin")) {
//                response.sendRedirect("/admin");
//            }
//        }
//
//    }


