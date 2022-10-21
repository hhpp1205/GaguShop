package kr.ac.kopo.dao;

import kr.ac.kopo.model.Orders;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDaoImpl implements OrdersDao {

    @Autowired
    SqlSession sql;

    @Override
    public void order(Orders orders) {
        sql.insert("orders.createOrder",orders);
    }

    @Override
    public void deleteOrdersByGaguId(int id) {
        sql.delete("orders.deleteOrdersByGaguId", id);
    }
}
