package kr.ac.kopo.controller;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;
import kr.ac.kopo.util.Pager;
import kr.ac.kopo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

            //어드민으로 로그인했을 때
            String memberId = member.getId();
            if(memberId.equals("admin"))
                return "admin";

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

    @PostMapping("/findId")
    public  String findId(Member member, Model model){
        List<Member> list = service.findId(member);

        model.addAttribute("list", list);

        return "newid";
    }
    @ResponseBody
    @PostMapping("/findIdCheck")
    public String findIdCheck(Member member){
        int result = service.findIdCheck(member);

        if(result == 0){
            return "NO";
        }else {
            return "OK";
        }
    }

    @PostMapping("/findPwd")
    public String findPwd(Member member, Model model){
        boolean check;
        check = service.findPwd(member);

        if(check){
            model.addAttribute("member", member);
            return "newpwd";
        }else{
            return "findaccount";
        }
    }
    @ResponseBody
    @PostMapping("/findPwdCheck")
    public String findPwdCheck(Member member){
        int result = service.findPwdCheck(member);

        if(result == 1){
            return "OK";
        }else {
            return "NO";
        }
    }

    @PostMapping("/newPwd")
    public String newPwd(Member member){

        service.newPwd(member);

        return "login";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin/admin";
    }

    @GetMapping("/admin/gagumanager")
    public String gagumanager(Pager pager, Model model){
        List<Gagu> list = service.adminGagu(pager);
        model.addAttribute("list", list);
        model.addAttribute("pager", pager);
        return "/admin/gagumanager";
    }

}
