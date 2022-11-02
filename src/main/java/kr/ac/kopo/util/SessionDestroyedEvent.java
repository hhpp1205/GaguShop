package kr.ac.kopo.util;

import kr.ac.kopo.dao.WishDao;
import kr.ac.kopo.dao.WishDaoImpl;
import kr.ac.kopo.model.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Enumeration;

@Component
public class SessionDestroyedEvent implements HttpSessionListener {

    @Autowired
    WishDao wishDao;

    @Override

    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("SessionDestroyedEvent.sessionCreated");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();

        Enumeration<String> e = session.getAttributeNames();

        while (e.hasMoreElements()) {
            String sessionName = e.nextElement();

            Object findSession = session.getAttribute(sessionName);

            if (findSession instanceof Wish) {
                    wishDao.addWish((Wish) findSession);
            }
        }

    }
}
