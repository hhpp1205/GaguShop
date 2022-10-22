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
    public void addCart(Cart cart) {
        sql.insert("cart.addCart", cart);
    }

    @Override
    public int checkCart(Cart cart) {
        return sql.selectOne("cart.checkCart", cart);
    }

    @Override
    public List<Gagu> cartList(String memberId) {
        return sql.selectList("cart.cartList", memberId);
    }

    @Override
    public void deleteCart(Cart cart) {
        sql.delete("cart.deleteCart", cart);
    }

    @Override
    public void deleteCartByGaguId(int id) {
        sql.delete("cart.deleteCartByGaguId", id);
    }

    @Override
    public void deleteCartByCartId(int cartId) {
        sql.delete("cart.deleteCartByCartId", cartId);
    }
}
