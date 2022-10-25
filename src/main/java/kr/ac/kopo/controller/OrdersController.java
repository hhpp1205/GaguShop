package kr.ac.kopo.controller;

import kr.ac.kopo.model.Cart;
import kr.ac.kopo.model.Member;
import kr.ac.kopo.model.Orders;
import kr.ac.kopo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    OrdersService orderService;

    //주문 내역 페이지
    @GetMapping("/")
    public String order(Orders orders, @SessionAttribute Member member){
        orders.setMemberId(member.getId());
        orderService.order(orders);
        return "index";
    }

    @ResponseBody
    @PostMapping("/")
    public String addOrders(Orders orders, @SessionAttribute Member member){
        orders.setMemberId(member.getId());
        orderService.addOrders(orders);

        return "OK";
    }
}

