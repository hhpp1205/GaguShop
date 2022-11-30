package kr.ac.kopo.dao;

import kr.ac.kopo.model.AdminTotal;
import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Orders;
import kr.ac.kopo.util.Pager;
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

    @Override
    public int payment(Orders orders) {
        return sql.insert("orders.payment", orders);
    }

    @Override
    public List<Orders> adminList(Pager pager) {
        return sql.selectList("orders.adminList", pager);
    }

    @Override
    public AdminTotal adminTotal() {
        return sql.selectOne("orders.monthTotalSalePrice");
    }

    @Override
    public AdminTotal mostSaleProduct() {
        return sql.selectOne("orders.monthMostSaleProduct");
    }
}
