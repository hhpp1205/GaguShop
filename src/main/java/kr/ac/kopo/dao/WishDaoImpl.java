package kr.ac.kopo.dao;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;
import kr.ac.kopo.model.Wish;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WishDaoImpl implements WishDao {


    private final SqlSession sql;

    @Override
    public int checkWish(Wish wish) {
        return sql.selectOne("wish.checkWish", wish);
    }

    @Override
    public void addWish(Wish wish) {
        sql.insert("wish.addWish", wish);
    }

    @Override
    public int deleteWish(Wish wish) {
        return sql.delete("wish.deleteWish", wish);
    }

    @Override
    public void deleteWishByGaguId(int id) {
        sql.delete("wish.deleteWishByGaguId", id);
    }

    @Override
    public List<Gagu> allCheckWishByMemberId(Member member) {
        return sql.selectList("wish.allCheckWishByMemberId", member);
    }

}