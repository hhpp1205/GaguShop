package kr.ac.kopo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
    private int id;
    private int count;
    private String memberId;
    private int gaguId;

}
