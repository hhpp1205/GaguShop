package kr.ac.kopo.dao;

import kr.ac.kopo.model.Cart;
import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Orders;

import java.util.HashMap;
import java.util.List;

public interface CartDao {
    void addCart(Cart cart);

    int checkCart(Cart cart);

    List<Gagu> cartList(String memberId);

    void deleteCart(Cart cart);

    void deleteCartByGaguId(int id);

    void deleteCartByCartId(int cartId);

    void deleteCart(Orders orders);
}
