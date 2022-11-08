package kr.ac.kopo.controller;

import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;
import kr.ac.kopo.service.GaguService;
import kr.ac.kopo.util.Pager;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.validation.MemberAddForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class RootController {

    @Autowired
    MemberService service;
    @Autowired
    GaguService gaguService;

    @GetMapping("/")
    public String index(Model model){
            List<Gagu> list = gaguService.list();
            model.addAttribute("list", list);
            return "index";
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
    public String signupForm(Model model){
        model.addAttribute("member", new Member());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Validated @ModelAttribute("member") MemberAddForm form, BindingResult bindingResult, Model model){

        //비밀번호 비밀번호확인 검증
        if (!form.getPwd().equals(form.getPwdCheck())) {
            bindingResult.reject("pwdNotMatch", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }

        //오류 발생
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "/signup";
        }

        //성공로직
        Member member = new Member();
        member.setId(form.getId());
        member.setPwd(form.getPwd());
        member.setName(form.getName());
        member.setPhoneNumber(form.getPhoneNumber());

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



}
