package kr.ac.kopo.dao;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Orders;

import java.util.List;

public interface OrdersDao {

    void deleteOrdersByGaguId(int id);

    void addOrders(Orders orders);

    List<Gagu> list(String memberId);

    int payment(Orders orders);
}
