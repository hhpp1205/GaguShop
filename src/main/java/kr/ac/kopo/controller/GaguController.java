package kr.ac.kopo.controller;

import kr.ac.kopo.model.*;
import kr.ac.kopo.service.GaguService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/gagu")
public class GaguController {

    @Autowired
    GaguService service;

    final String path = "gagu/";

    @GetMapping("/add")
    public String add(Model model){
        List<String> list = service.keywordList();

        model.addAttribute("list", list);

        return path + "add";
    }

    @PostMapping("/add")
    public String add(Gagu item, @RequestParam(value = "file", required = false)MultipartFile file, @SessionAttribute Member member) throws IOException {

             item.setMemberId(member.getId());
        try{
            if(!file.isEmpty()){
                String filename = file.getOriginalFilename();
                file.transferTo(new File("C:/img\\" + filename));
                item.setGaguImg(filename);
            }


            List<Attach> list = new ArrayList<Attach>();

            for(MultipartFile attach : item.getAttach()){
                if(attach != null && !attach.isEmpty()){
                    attach.transferTo(new File("C:/img\\" + attach.getOriginalFilename()));

                    Attach attachItem = new Attach();

                    attachItem.setFilename(attach.getOriginalFilename());
                    list.add(attachItem);
                }
            }
            item.setAttachs(list);

            service.add(item);

        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:../";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable int id, Model model, HttpSession session){
        Wish wish = new Wish();
        wish.setGaguId(id);
        Member member = (Member) session.getAttribute("member");
        if(member == null){ // 로그인 전
            Gagu item = service.info(id);
            model.addAttribute("item", item);

            return path + "info";
        }else{ // 로그인 후
            wish.setMemberId(member.getId());
            if(service.checkWish(wish) == 0){
                Gagu item = service.info(id);
                item.setWishId(0);
                model.addAttribute("item", item);
                return path + "info";
            }else {
                Gagu item = service.info(id);
                item.setWishId(1);
                model.addAttribute("item", item);
                return path + "info";
            }
        }
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        Gagu item = service.info(id);
        model.addAttribute("item", item);

        return path + "update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, Gagu item, @SessionAttribute Member member){
        item.setMemberId(member.getId());
        service.update(item);

        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id, @SessionAttribute Member member){
        service.delete(id);

        return "redirect:/";
    }

    @ResponseBody
    @PostMapping("/addCart")
    public String addCart(Cart cart, @SessionAttribute Member member){
        cart.setMemberId(member.getId());

        if(service.checkCart(cart) == 0){
            service.addCart(cart);
            return "add";
        }else {
            return "alreadyExist";
        }

    }

    @GetMapping("/cart")
    public String cart(Model model, HttpSession session){
        Member member = (Member)session.getAttribute("member");
        String memberId = member.getId();

        List<Gagu> list = service.cartList(memberId);
        model.addAttribute("list", list);

        return path + "cart";
    }

    @PostMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model){
        List<Gagu> list = service.search(keyword);

        model.addAttribute("list", list);
        model.addAttribute("keyword", keyword);

        return "gagu/search";
    }
    @ResponseBody
    @PostMapping("/wish")
    public String addDeleteWish(Wish wish, @SessionAttribute Member member){
        wish.setMemberId(member.getId());
        if(service.checkWish(wish) == 0){
            service.addWish(wish);
            return "add";
        }else {
            service.deleteWish(wish);
            return "delete";
        }
    }
}
