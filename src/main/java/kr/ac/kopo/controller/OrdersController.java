package kr.ac.kopo.controller;

import kr.ac.kopo.model.Member;
import kr.ac.kopo.model.Orders;
import kr.ac.kopo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    OrdersService orderService;

    @PostMapping("/")
    public String order(Orders orders, @SessionAttribute Member member){
        orders.setMemberId(member.getId());
        orderService.order(orders);
        return "index";
    }
}

