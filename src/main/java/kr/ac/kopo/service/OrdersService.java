package kr.ac.kopo.service;

import kr.ac.kopo.model.AdminTotal;
import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Orders;
import kr.ac.kopo.util.Pager;

import java.util.List;

public interface OrdersService {



    void addOrders(Orders orders);

    List<Gagu> list(String memberId);

    int payment(Orders orders);

    List<Orders> adminList(Pager pager);

    AdminTotal adminTotal();
}
