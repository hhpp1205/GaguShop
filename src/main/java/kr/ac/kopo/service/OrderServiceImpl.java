package kr.ac.kopo.service;

import kr.ac.kopo.dao.OrderDao;
import kr.ac.kopo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public void order(Order order) {
        orderDao.order(order);
    }
}
