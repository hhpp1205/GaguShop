package kr.ac.kopo.controller;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;
import kr.ac.kopo.service.GaguService;
import kr.ac.kopo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/")
public class RootController {

    @Autowired
    MemberService service;

    @GetMapping("/")
    public String index(Model model, HttpSession session){
        Member member = (Member) session.getAttribute("member");
//        if(member == null){
            List<Gagu> list = service.beforeLoginList();
            model.addAttribute("list", list);
            return "index";
//        }
//        String memberId = member.getId();
//        List<Gagu> list = service.afterLoginList(memberId);
//        model.addAttribute("list", list);
//        return "index";
    }

    @GetMapping("/login")
    public  String login() {
        return "login";
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(Member member, HttpSession session){
        if(service.login(member)){

            session.setAttribute("member", member);
            return "OK";
        }else {
            return "NO";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();

        return "redirect:.";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(Member member){
            service.signup(member);
            return "redirect:login";
    }

    @ResponseBody
    @PostMapping("checkId")
    public String checkId(String id){
        if(service.checkId(id))
            return "OK";
        else
            return "FAIL";
    }

    @GetMapping("findaccount")
    public String findaccount(){
        return "findaccount";
    }

    @PostMapping("findId")
    public  String findId(Member member, Model model){
        Member item = new Member();
        item = service.findId(member);

        model.addAttribute("item", item);

        return "newid";
    }

    @PostMapping("/findPwd")
    public String findPwd(Member member, HttpSession session){
        boolean check;
        check = service.findPwd(member);

        if(check){
            session.setAttribute("member", member);
            return "newpwd";
        }else{
            return "findaccount";
        }

    }

    @PostMapping("/newPwd")
    public String newPwd(Member member){

        service.newPwd(member);

        return "login";
    }


}
