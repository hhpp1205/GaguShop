package kr.ac.kopo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Order {

    private int id;
    private int count;
    private Date saleDate;

    //Gagu
    private int gaguId;
    //Member
    private String memberId;

}
