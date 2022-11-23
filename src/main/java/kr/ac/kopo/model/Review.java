package kr.ac.kopo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Review {

    private int id;
    private String reviewImg;
    private int reviewStar;
    private String comment;
    private Date regDate;

    private int gaguId;
    private String memberId;

}
