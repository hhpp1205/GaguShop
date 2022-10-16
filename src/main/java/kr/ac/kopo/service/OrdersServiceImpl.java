package kr.ac.kopo.service;

import kr.ac.kopo.dao.OrdersDao;
import kr.ac.kopo.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersDao orderDao;

    @Override
    public void order(Orders orders) {
        orderDao.order(orders);
    }
}
