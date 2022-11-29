package kr.ac.kopo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Orders {

    private int id;
    private int count;
    private int price;
    private int total;
    private String address;
    private String addressDetail;
    private Date saleDate;

    //Gagu
    private int gaguId;
    //Member
    private String memberId;
    //Cart
    private int cartId;

}
