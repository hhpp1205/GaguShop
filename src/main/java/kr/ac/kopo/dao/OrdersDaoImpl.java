package kr.ac.kopo.dao;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Orders;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrdersDaoImpl implements OrdersDao {


    private final SqlSession sql;



    @Override
    public void deleteOrdersByGaguId(int id) {
        sql.delete("orders.deleteOrdersByGaguId", id);
    }

    @Override
    public void addOrders(Orders orders) {
        sql.insert("orders.addOrders", orders);
    }

    @Override
    public List<Gagu> list(String memberId) {
        return sql.selectList("orders.list", memberId);
    }
}
