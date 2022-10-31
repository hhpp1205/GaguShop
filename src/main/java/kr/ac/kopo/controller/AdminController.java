package kr.ac.kopo.controller;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    MemberService memberService;


    @GetMapping("/admin")
    public String admin(){
        return "admin/admin";
    }

    @GetMapping("/admin/gagumanager")
    public String gagumanager(Pager pager, Model model){
        List<Gagu> list = memberService.adminGagu(pager);
        model.addAttribute("list", list);
        model.addAttribute("pager", pager);
        return "/admin/gagumanager";
    }


}
