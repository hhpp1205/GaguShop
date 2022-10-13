package kr.ac.kopo.controller;

import kr.ac.kopo.model.Attach;
import kr.ac.kopo.model.Cart;
import kr.ac.kopo.model.Gagu;
import kr.ac.kopo.model.Member;
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



        //        try {
//            file.transferTo(new File("C:/img\\" + file.getOriginalFilename()));
//            item.setGaguImg(file.getOriginalFilename());
//            item.setMemberId(member.getId());
//
//            List<Attach> list = new ArrayList<>();
//
//            for(MultipartFile attach : item.getAttach()){
//                if(attach != null && !attach.isEmpty()){
//                    String filename = attach.getOriginalFilename();
//
//                    attach.transferTo(new File("C:/img\\" + filename));
//
//                    Attach attachItem = new Attach();
//                    attachItem.setFilename(filename);
//
//                    list.add(attachItem);
//                }
//            }
//            item.setAttachs(list);
//
//            service.add(item);
//        }catch (Exception e){
//            e.printStackTrace();
//


    @GetMapping("/info/{id}")
    public String info(@PathVariable int id, Model model){
        Gagu item = service.info(id);
        model.addAttribute("item", item);

        return path + "info";
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

    @PostMapping("/addDeleteCart/{id}")
    public String addCart(@PathVariable int id, @SessionAttribute Member member,@RequestParam int cartId, HttpSession session ){
        HashMap map = new HashMap<>();

        map.put("memberId", member.getId());
        map.put("gaguId", id);
        map.put("id", cartId);

        service.addDeleteCart(map);

        return "redirect:/";
    }

    @GetMapping("/cart")
    public String cart(Model model, HttpSession session){
        Member member = (Member)session.getAttribute("member");
        String memberId = member.getId();

        List<Gagu> list = service.cartList(memberId);
        model.addAttribute("list", list);

        return path + "cart";
    }
}
