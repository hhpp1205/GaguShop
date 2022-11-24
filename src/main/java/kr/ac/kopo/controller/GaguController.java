package kr.ac.kopo.controller;

import kr.ac.kopo.model.*;
import kr.ac.kopo.util.MultipartBinder;
import kr.ac.kopo.util.Pager;
import kr.ac.kopo.service.GaguService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.List;

/**
 * TODO
 * 1. Gagu 등록시 검증 기능
 * 2. Gagu 변경시 검증 기능
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/gagu")
public class GaguController {


    private final GaguService service;


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
                item.setGaguImg(binder.saveImgAndReturnName(file));
            }

            binder.saveItemSubImg(item);

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

        //가구
        Gagu item = service.info(id);
        //리뷰
        List<Review> reviewList = service.getReviewByGaguId(id);

        model.addAttribute("item", item);
        model.addAttribute("reviewList", reviewList);

        // 로그인 전
        if(member == null){
            return path + "info";
        // 로그인 후
        }else{
            wish.setMemberId(member.getId());
            if(service.checkWish(wish) == 0){
                item.setWishId(0);
                return path + "info";
            }else {
                item.setWishId(1);
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
                String filename = binder.saveImgAndReturnName(file);
                item.setGaguImg(filename);

                binder.saveItemSubImg(item);

                service.update(item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
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

    @ResponseBody
    @PostMapping("/deleteCart")
    public String deleteCart(@RequestParam int cartId){
        if (service.deleteCartByCartId(cartId) == 1) {
            return "OK";
        } else {
            return "FAIL";
        }
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
        if (member.getId().isEmpty()) {
            return "FAIL";
        }

        wish.setMemberId(member.getId());
        service.addWish(wish);
        return "add";
    }

    @ResponseBody
    @PostMapping("/deleteWish")
    public String deleteWish(Wish wish, @SessionAttribute Member member){
            wish.setMemberId(member.getId());
        if (service.deleteWish(wish) == 1) {
            return "delete";
        }
            return "FAIL";
    }

    @GetMapping("/wish")
    public String wish(@SessionAttribute Member member, Model model){
        List<Gagu> list = service.allCheckWishByMemberId(member);

        model.addAttribute("list", list);
        return path + "/wish";
    }

    @GetMapping("/addReview/{gaguId}")
    public String reviewForm(@PathVariable int gaguId, Model model){
        model.addAttribute("gaguId", gaguId);
        return path + "reviewAdd";
    }

    @PostMapping("/review")
    public String addReview(@RequestParam(required = false) MultipartFile file, Review review,
                            @SessionAttribute Member member, RedirectAttributes redirectAttributes){
        MultipartBinder binder = new MultipartBinder();

        if (!file.isEmpty()) {
            String fileName = binder.saveImgAndReturnName(file);
            review.setReviewImg(fileName);
        }

        review.setMemberId(member.getId());

        service.addReview(review);

        redirectAttributes.addAttribute("gaguId", review.getGaguId());
        return "redirect:/gagu/info/{gaguId}";
    }

    @PostMapping("/updateReview")
    public String updateReview(Review review, @SessionAttribute Member member, RedirectAttributes redirectAttributes){
        if (member.getId().equals(review.getMemberId())) {
            redirectAttributes.addAttribute("gaguId", review.getGaguId());
            service.updateReview(review);
        }
        return "redirect:/gagu/info/{gaguId}";
    }

    @GetMapping("/deleteReview/{id}/{memberId}/{gaguId}")
    public String deleteReview(@PathVariable int id, @PathVariable String memberId,
                               @PathVariable int gaguId, @SessionAttribute Member member,
                               RedirectAttributes redirectAttributes){

        if (member.getId().equals(memberId)) {
            service.deleteReviewById(id);

            redirectAttributes.addAttribute("gaguId", gaguId);

            return "redirect:/gagu/info/{gaguId}";
        }
        return "list";
    }

}
