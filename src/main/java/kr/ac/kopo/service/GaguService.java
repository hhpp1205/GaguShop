package kr.ac.kopo.service;

import kr.ac.kopo.model.*;
import kr.ac.kopo.util.Pager;

import java.util.List;

public interface GaguService {
    void add(Gagu item);

    Gagu info(int id);

    void update(Gagu item);

    void delete(int id);
    
    List<Gagu> cartList(String memberId);

    List<String> keywordList();

    List<Gagu> search(String keyword, Pager pager, int changeSort);

    int checkCart(Cart cart);

    void addCart(Cart cart);

    void deleteCart(Cart cart);

    void addWish(Wish wish);

    int checkWish(Wish wish);

    int deleteWish(Wish wish);

    int total(Pager pager, String keyword);

    int searchCount(String keyword);

    void dummy(Member member);

    List<Gagu> allCheckWishByMemberId(Member member);

    int deleteCartByCartId(int cartId);

    void init(Member member);

    List<Gagu> list();


    void addReview(Review review);



    List<Review> getReviewByGaguId(int id);
}
