package kr.ac.kopo.service;

import kr.ac.kopo.dao.CartDao;
import kr.ac.kopo.dao.OrdersDao;
import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersDao orderDao;
    @Autowired
    CartDao cartDao;


    @Transactional
    @Override
    public void addOrders(Orders orders) {
        orderDao.addOrders(orders);
        cartDao.deleteCart(orders);
    }

    @Override
    public List<Gagu> list(String memberId) {
        return orderDao.list(memberId);
    }
}
