package kr.ac.kopo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class Gagu {
    private int id;
    private String name;
    private int price;
    private String gaguImg;
    private String keyword;
    private String memberId;

    //Cart
    private int cartId;

    //Attach
    private List<MultipartFile> attach;
    private List<Attach> attachs;

    //Wish
    //wish가 존재하면 1 존재하지 않으면 0
    private int wishId;

}
