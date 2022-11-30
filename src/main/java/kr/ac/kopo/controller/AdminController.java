package kr.ac.kopo.controller;

import kr.ac.kopo.model.AdminTotal;
import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Orders;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.OrdersService;
import kr.ac.kopo.util.Pager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {


    private final MemberService memberService;
    private final OrdersService ordersService;

    @GetMapping
    public String admin(){
        return "admin/admin";
    }

    @GetMapping("/gagumanager")
    public String gaguManager(Pager pager, Model model){
        List<Gagu> list = memberService.adminGagu(pager);
        model.addAttribute("list", list);
        model.addAttribute("pager", pager);
        return "/admin/gagumanager";
    }

    @GetMapping("/ordersmanager")
    public String ordersManager(Pager pager, Model model) {
        List<Orders> list = ordersService.adminList(pager);
        AdminTotal adminTotal = ordersService.adminTotal();
        model.addAttribute("list", list);
        model.addAttribute("adminTotal", adminTotal);

        return "/admin/ordersmanager";
    }


}
