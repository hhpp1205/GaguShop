package kr.ac.kopo.service;

import kr.ac.kopo.model.Cart;
import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Pager;
import kr.ac.kopo.model.Wish;

import java.util.HashMap;
import java.util.List;

public interface GaguService {
    void add(Gagu item);

    Gagu info(int id);

    void update(Gagu item);

    void delete(int id);
    
    List<Gagu> cartList(String memberId);

    List<String> keywordList();

    List<Gagu> search(String keyword, Pager pager);

    int checkCart(Cart cart);

    void addCart(Cart cart);

    void deleteCart(Cart cart);

    void addWish(Wish wish);

    int checkWish(Wish wish);

    void deleteWish(Wish wish);

    int total(Pager pager);
}
