package kr.ac.kopo.controller;

import kr.ac.kopo.model.*;
import kr.ac.kopo.util.MultipartBinder;
import kr.ac.kopo.util.Pager;
import kr.ac.kopo.service.GaguService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


@Controller
@RequestMapping("/gagu")
public class GaguController {

    @Autowired
    GaguService service;

//    @Autowired
//    GaguValidator gaguvalidator;
//    @InitBinder("Gagu")
//    public void init(WebDataBinder dataBinder){
//        dataBinder.addValidators(gaguvalidator);
//    }

    final String path = "gagu/";

    @GetMapping("/add")
    public String add(Model model){
        List<String> list = service.keywordList();

        model.addAttribute("list", list);

        return path + "add";
    }

    @PostMapping("/add")
    public String add(Gagu item, @RequestParam(value = "file", required = false)MultipartFile file, @SessionAttribute Member member, Model model) throws IOException {

        MultipartBinder binder = new MultipartBinder();

        item.setMemberId(member.getId());
        try{
            if(!file.isEmpty()){
                String filename = binder.saveReturnName(file);
                item.setGaguImg(filename);
            }

            List<Attach> list = new ArrayList<Attach>();


            if (item.getAttach() != null) {
                for(MultipartFile attach : item.getAttach()){
                    if(attach != null && !attach.isEmpty()){
                        Attach attachItem = new Attach();

                        attachItem.setFilename(binder.saveReturnName(attach));
                        list.add(attachItem);
                    }
                }
                item.setAttachs(list);
            }
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

    @GetMapping("/init")
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
        // 로그인 전
        if(member == null){
            Gagu item = service.info(id);
            model.addAttribute("item", item);
            return path + "info";
        // 로그인 후
        }else{
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
        MultipartBinder binder = new MultipartBinder();

        item.setMemberId(member.getId());
        try {
            if(!file.isEmpty()){
                String filename = binder.saveReturnName(file);
                item.setGaguImg(filename);

                List<Attach> list = new ArrayList<Attach>();

                for(MultipartFile attach : item.getAttach()){
                    if(attach != null && !attach.isEmpty()){
                        Attach attachItem = new Attach();

                        attachItem.setFilename(binder.saveReturnName(attach));
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
        if(member.getId().equals("admin")){
            service.delete(id);

            return "redirect:/admin/gagumanager";
        }
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

    @ResponseBody
    @PostMapping("/addWish")
    public String addWish(Wish wish, @SessionAttribute Member member, HttpSession session){
//        String gaguId = Integer.toString(wish.getGaguId());
//
//        wish.setMemberId(member.getId());
//        session.setAttribute(gaguId, wish);

        service.addWish(wish);
        return "add";
    }

    @ResponseBody
    @PostMapping("/deleteWish")
    public String deleteWish(Wish wish, @SessionAttribute Member member){
            wish.setMemberId(member.getId());
            service.deleteWish(wish);
            return "delete";
    }

    @GetMapping("/wish")
    public String wish(@SessionAttribute Member member, Model model){
        List<Gagu> list = service.allCheckWishByMemberId(member);

        model.addAttribute("list", list);
        return path + "/wish";
    }

    @GetMapping("/wishDelete/{gaguId}/{memberId}")
    public String wishDelete(@PathVariable int gaguId, @PathVariable String memberId){
        Wish wish = new Wish();
        wish.setGaguId(gaguId);
        wish.setMemberId(memberId);

        service.deleteWish(wish);


        return "redirect:/gagu/wish";
    }

}
