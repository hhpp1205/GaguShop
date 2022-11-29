package kr.ac.kopo.service;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Orders;

import java.util.List;

public interface OrdersService {



    void addOrders(Orders orders);

    List<Gagu> list(String memberId);

    int payment(Orders orders);
}
