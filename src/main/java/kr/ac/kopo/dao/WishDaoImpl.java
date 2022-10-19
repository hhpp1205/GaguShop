package kr.ac.kopo.dao;

import kr.ac.kopo.model.Wish;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WishDaoImpl implements WishDao {

    @Autowired
    SqlSession sql;

    @Override
    public int checkWish(Wish wish) {
        return sql.selectOne("wish.checkWish", wish);
    }

    @Override
    public void addWish(Wish wish) {
        sql.insert("wish.addWish", wish);
    }

    @Override
    public void deleteWish(Wish wish) {
        sql.delete("wish.deleteWish", wish);
    }

    @Override
    public void deleteById(int id) {
        sql.delete("deleteById", id);
    }
}
