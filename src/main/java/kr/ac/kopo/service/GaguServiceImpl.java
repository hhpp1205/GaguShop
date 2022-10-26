package kr.ac.kopo.service;

import kr.ac.kopo.dao.*;
import kr.ac.kopo.model.*;
import kr.ac.kopo.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    OrdersDao ordersDao;


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

        int gaguId = item.getId();
        attachDao.deleteAttachByGaguId(gaguId);

        for(Attach attach : item.getAttachs()){
            attach.setGaguId(item.getId());
            attachDao.add(attach);
        }
    }
    @Transactional
    @Override
    public void delete(int id) {
        attachDao.deleteAttachByGaguId(id);
        cartDao.deleteCartByGaguId(id);
        ordersDao.deleteOrdersByGaguId(id);
        wishDao.deleteWishByGaguId(id);
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
    @Transactional
    @Override
    public List<Gagu> search(String keyword, Pager pager, int changeSort) {
        pager.setTotal(dao.total(pager, keyword));
        return dao.search(keyword, pager, changeSort);
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

//    @Override
//    public int checkWish(Wish wish) {
//        return  wishDao.checkWish(wish);
//    }

    @Override
    public int checkWish(Wish wish) {
        int result = wishDao.checkWish(wish);

        if(result == 0){
            wishDao.addWish(wish);
        }else {
            wishDao.deleteWish(wish);
        }
        return result;
    }

    @Override
    public void deleteWish(Wish wish) {
        wishDao.deleteWish(wish);
    }

    @Override
    public int total(Pager pager, String keyword) {
        return dao.total(pager, keyword);
    }

    @Override
    public int searchCount(String keyword) {
        return dao.searchCount(keyword);
    }

    @Override
    public void dummy(Member member) {
        for(int i = 0; i < 100; i++){
            Gagu item = new Gagu();
            item.setMemberId(member.getId());
            item.setName("테스트" + i);
            item.setPrice(1000*i);
            item.setKeyword("거실장");

            dao.add(item);
        }
    }

    @Override
    public List<Gagu> allCheckWishByMemberId(Member member) {
         return wishDao.allCheckWishByMemberId(member);
    }

    @Override
    public void deleteWishById(int wishId) {
        wishDao.deleteWishById(wishId);
    }

    @Override
    public void deleteCartByCartId(int cartId) {
        cartDao.deleteCartByCartId(cartId);
    }

}
