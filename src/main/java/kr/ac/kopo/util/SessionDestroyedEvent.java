//package kr.ac.kopo.util;
//
//import kr.ac.kopo.model.Wish;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSessionEvent;
//import javax.servlet.http.HttpSessionListener;
//import java.util.Enumeration;
//
//public class SessionDestroyedEvent implements HttpSessionListener {
//
//
//
//
//    @Override
//    public void sessionCreated(HttpSessionEvent se) {
//    }
//
//    @Override
//    public void sessionDestroyed(HttpSessionEvent se) {
//        HttpSession session = se.getSession();
//
//
//        Enumeration<String> e = session.getAttributeNames();
//
//        while (e.hasMoreElements()) {
//            String sessionName = e.nextElement();
//
//            Object findSession = session.getAttribute(sessionName);
//
//            if (findSession instanceof Wish) {
//                System.out.println("findSession = " + findSession);
//            }
//        }
//
//    }
//}
