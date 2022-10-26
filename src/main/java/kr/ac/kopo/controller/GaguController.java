package kr.ac.kopo.controller;

import kr.ac.kopo.model.*;
import kr.ac.kopo.pager.Pager;
import kr.ac.kopo.service.GaguService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    @GetMapping("/dummy")
    public String dummy(@SessionAttribute Member member){
        if(member.getId().equals("admin")){
            service.dummy(member);

            return "redirect:/admin/gagumanager";
        }
        return "redirect:/";
    }

    @GetMapping("init")
    public String init(@SessionAttribute Member member){
        if(member.getId().equals("admin")){
            service.init(member);

            return "redirect:/admin/gagumanager";
        }
        return "redirect:/";
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
        List<String> keywordList = service.keywordList();
        model.addAttribute("keywordList", keywordList);
        model.addAttribute("item", item);

        return path + "update";
    }

    @PostMapping("/update")
    public String update(Gagu item, @RequestParam(value = "file", required = false)MultipartFile file, @SessionAttribute Member member){
        item.setMemberId(member.getId());
        try {
            if(!file.isEmpty()){
                String filename = file.getOriginalFilename();
                file.transferTo(new File("C:/img\\" + filename));
                item.setGaguImg(filename);

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
                service.update(item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id, @SessionAttribute Member member){
        service.delete(id);

        return "redirect:/admin/gagumanager";
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
    public String cart(Model model, @SessionAttribute Member member){
        String memberId = member.getId();

        List<Gagu> list = service.cartList(memberId);
        model.addAttribute("list", list);

        return path + "/cart";
    }

    @GetMapping("/deleteCart/{cartId}")
    public String deleteCart(@PathVariable int cartId){
        service.deleteCartByCartId(cartId);

        return "redirect:/gagu/cart";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword,
                         @RequestParam(value = "changeSort", defaultValue = "0")int changeSort, Model model, Pager pager){

        List<Gagu> list = service.search(keyword, pager, changeSort);
        // 상품 검색결과 갯수
        int searchCount = service.searchCount(keyword);

        model.addAttribute("changeSort", changeSort);
        model.addAttribute("searchCount", searchCount);
        model.addAttribute("pager", pager);
        model.addAttribute("keyword", keyword);
        model.addAttribute("list", list);

        return "gagu/search";
    }

//    @ResponseBody
//    @PostMapping("/wish")
//    public String addDeleteWish(Wish wish, @SessionAttribute Member member){
//
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//
//        wish.setMemberId(member.getId());
//        if(service.checkWish(wish) == 0){
//            service.addWish(wish);
//            stopWatch.stop();
//            System.out.println(stopWatch.prettyPrint());
//            return "add";
//        }else {
//            service.deleteWish(wish);
//            stopWatch.stop();
//            System.out.println(stopWatch.prettyPrint());
//            return "delete";
//        }
//    }

    @ResponseBody
    @PostMapping("/wish")
    public String addDeleteWish(Wish wish, @SessionAttribute Member member){

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        wish.setMemberId(member.getId());
        if(service.checkWish(wish) == 0){
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
            return "add";
        }else {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
            return "delete";
        }
    }

    @GetMapping("/wish")
    public String wish(@SessionAttribute Member member, Model model){
        List<Gagu> list = service.allCheckWishByMemberId(member);

        model.addAttribute("list", list);
        return path + "/wish";
    }

    @GetMapping("/wishDelete/{wishId}")
    public String wishDelete(@PathVariable int wishId, @SessionAttribute Member member){
        service.deleteWishById(wishId);


        return "redirect:/gagu/wish";
    }

}
