package kr.ac.kopo.dao;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;
import kr.ac.kopo.model.Wish;

import java.util.List;

public interface WishDao {
    int checkWish(Wish wish);

    void addWish(Wish wish);

    void deleteWish(Wish wish);

    void deleteWishByGaguId(int id);

    List<Gagu> allCheckWishByMemberId(Member member);

    void deleteWishById(int wishId);
}
