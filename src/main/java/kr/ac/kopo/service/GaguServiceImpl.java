package kr.ac.kopo.service;

import kr.ac.kopo.dao.AttachDao;
import kr.ac.kopo.dao.CartDao;
import kr.ac.kopo.dao.GaguDao;
import kr.ac.kopo.model.Attach;
import kr.ac.kopo.model.Cart;
import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class GaguServiceImpl implements GaguService{

    @Autowired
    GaguDao dao;
    @Autowired
    CartDao cartDao;
    @Autowired
    AttachDao attachDao;


    @Override
    @Transactional
    public void add(Gagu item) {
        dao.add(item);

        for(Attach attach : item.getAttachs()){
            attach.setGaguId(item.getId());

            attachDao.add(attach);
        }
    }

    @Override
    public Gagu info(int id) {
        return dao.info(id);

    }

    @Override
    public void update(Gagu item) {
        dao.update(item);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void addDeleteCart(HashMap map) {
        int cnt = cartDao.checkCart(map);
        if(cnt == 0){
            cartDao.addCart(map);
        }
            cartDao.deleteCart(map);
    }
    @Override
    public List<Gagu> cartList(String memberId) {
        return cartDao.cartList(memberId);
    }

    @Override
    public List<String> keywordList() {
        return dao.keywordList();
    }


}
