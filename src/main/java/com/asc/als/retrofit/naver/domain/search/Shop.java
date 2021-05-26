package com.asc.als.retrofit.naver.domain.search;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop implements Serializable {

    private String rss;
    private String channel;

    // @DateTimeFormat(pattern = "E, d MMM yyyy HH:mm:ss Z")
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "EEE, d MMM yyyy HH:mm:ss Z")
    // @JsonSerialize(using = LocalDateTimeSerializer.class)
    // @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    // @JsonDeserialize(using = AscDateTimeDeserializer.class)
    // private LocalDate lastBuildDate;
    private String lastBuildDate;

    private Long total;
    private Long start;
    private Long display;
    private List<ShopItem> items;
    private String title;
    private String link;
    private String image;
    private int lprice;
    private int hprice;
    private String mallName;
    private int productId;
    private int productType;
    private String maker;
    private String brand;
    private String category1;
    private String category2;
    private String category3;
    private String category4;
}

