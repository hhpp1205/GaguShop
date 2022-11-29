package kr.ac.kopo.service;

import kr.ac.kopo.dao.CartDao;
import kr.ac.kopo.dao.OrdersDao;
import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Orders;
import kr.ac.kopo.util.Pager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {


    private final OrdersDao orderDao;

    private final CartDao cartDao;


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

    @Transactional
    @Override
    public int payment(Orders orders) {
        int payment = orderDao.payment(orders);
        if(payment == 1){
            cartDao.deleteForPayment(orders);
            return 1;
        }else {
            return 0;
        }

    }

    @Override
    public List<Orders> adminList(Pager pager) {
        return orderDao.adminList(pager);
    }
}
