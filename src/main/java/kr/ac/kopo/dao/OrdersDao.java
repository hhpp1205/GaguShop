package kr.ac.kopo.dao;

import kr.ac.kopo.model.Orders;

public interface OrdersDao {
    void order(Orders orders);

    void deleteOrdersByGaguId(int id);
}
