package com.asc.als.retrofit.naver.domain.search;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopItem implements Serializable {
    /* title, link */
    private String title;
    private String link;
    private String image;
    private int lprice;
    private int hprice;
    private String mallName;
    private String productId;
    private int productType;
    private String brand;
    private String maker;
    private String category1;
    private String category2;
    private String category3;
    private String category4;
}

