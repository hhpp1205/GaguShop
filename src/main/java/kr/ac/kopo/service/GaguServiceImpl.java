package kr.ac.kopo.service;

import kr.ac.kopo.dao.AttachDao;
import kr.ac.kopo.dao.CartDao;
import kr.ac.kopo.dao.GaguDao;
import kr.ac.kopo.dao.WishDao;
import kr.ac.kopo.model.*;
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
    @Autowired
    WishDao wishDao;


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
    public List<Gagu> cartList(String memberId) {
        return cartDao.cartList(memberId);
    }

    @Override
    public List<String> keywordList() {
        return dao.keywordList();
    }

    @Override
    public List<Gagu> search(String keyword, Pager pager) {
        pager.setTotal(dao.total(pager));
        return dao.search(keyword, pager);
    }

    @Override
    public int checkCart(Cart cart) {
        return cartDao.checkCart(cart);
    }

    @Override
    public void addCart(Cart cart) {
        cartDao.addCart(cart);
    }

    @Override
    public void deleteCart(Cart cart) {
        cartDao.deleteCart(cart);
    }

    @Override
    public void addWish(Wish wish) {
        wishDao.addWish(wish);
    }

    @Override
    public int checkWish(Wish wish) {
        return wishDao.checkWish(wish);
    }

    @Override
    public void deleteWish(Wish wish) {
        wishDao.deleteWish(wish);
    }

    @Override
    public int total(Pager pager) {
        return dao.total(pager);
    }

}
