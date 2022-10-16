package kr.ac.kopo.dao;

import kr.ac.kopo.model.Order;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    SqlSession sql;

    @Override
    public void order(Order order) {
        sql.insert("order.createOrder",order);
    }
}
