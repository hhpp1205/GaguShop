package kr.ac.kopo.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AdminTotal {
    private String monthTotalOrdersCnt;
    private String monthTotalPrice;
    private int monthMostSaleProduct;
    private int monthMostSaleProductCnt;
}
