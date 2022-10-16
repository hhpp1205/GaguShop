package kr.ac.kopo.controller;

import kr.ac.kopo.model.Member;
import kr.ac.kopo.model.Order;
import kr.ac.kopo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/")
    public String order(Order order, @SessionAttribute Member member){
        order.setMemberId(member.getId());
        orderService.order(order);
        return "index";
    }
}

