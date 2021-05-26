package com.asc.als.retrofit.naver.domain.search;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDateTime;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsItem implements Serializable {
    /* title, originallink, link, description, pubDate */
    private String title;
    private String originallink;
    private String link;
    private String description;
    private String pubDate;
}

