package kr.ac.kopo.dao;

import kr.ac.kopo.model.Cart;
import kr.ac.kopo.model.Gagu;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class CartDaoImpl implements CartDao{
    @Autowired
    SqlSession sql;
    @Override
    public void addCart(HashMap map) {
        sql.insert("cart.addCart", map);
    }

    @Override
    public int checkCart(HashMap map) {
        return sql.selectOne("cart.checkCart", map);
    }

    @Override
    public List<Gagu> cartList(String memberId) {
        return sql.selectList("cart.cartList", memberId);
    }

    @Override
    public void deleteCart(HashMap map) {
        sql.delete("cart.deleteCart", map);
    }
}
