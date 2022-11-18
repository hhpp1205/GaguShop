package kr.ac.kopo.controller;

import kr.ac.kopo.model.Cart;
import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;
import kr.ac.kopo.model.Orders;
import kr.ac.kopo.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrdersController {


    private final OrdersService orderService;

    //주문 내역 페이지
    @GetMapping("/")
    public String order(@SessionAttribute Member member, Model model){
        String memberId = member.getId();

        List<Gagu> list = orderService.list(memberId);

        model.addAttribute("list", list);

        return "/gagu/orders";
    }

    @ResponseBody
    @PostMapping("/")
    public String addOrders(Orders orders, @SessionAttribute Member member){
        if(member.getId().isEmpty()){
            return "FAIL";
        }else {
            orders.setMemberId(member.getId());

            orderService.addOrders(orders);

            return "OK";
        }
    }
}

