package kr.ac.kopo.dao;

import kr.ac.kopo.model.Wish;

public interface WishDao {
    int checkWish(Wish wish);

    void addWish(Wish wish);

    void deleteWish(Wish wish);

    void deleteById(int id);
}
