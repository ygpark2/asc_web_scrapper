package com.asc.als.scrapper.service;


import com.asc.als.domain.Category;
import com.asc.als.scrapper.config.Covid19BusinessConfiguration;
import com.asc.als.scrapper.config.NaverDatalabConfiguration;
import com.asc.als.scrapper.exceptions.KeyNotFoundException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.asc.als.scrapper.utils.ScrapingUtilities.*;

@Service
@Qualifier("naverDatalabScrapper")
public class NaverDatalabScrapperService implements ScrapperService<String> {
    private static final Logger logger = LoggerFactory.getLogger(NaverDatalabScrapperService.class);
    private final WebDriver webDriver;
    private final NaverDatalabConfiguration naverDatalabConfiguration;

    public NaverDatalabScrapperService(WebDriver webDriver, NaverDatalabConfiguration naverDatalabConfiguration) {
        this.webDriver = webDriver;
        this.naverDatalabConfiguration = naverDatalabConfiguration;
    }

    @Override
    public void navigate() {
        webDriver.navigate()
                .to(naverDatalabConfiguration.getSiteUrl());
    }

    @Override
    public void navigate(String url) {
        webDriver.navigate().to(url);
    }

    @Override
    public String scrape() {
        try {

            List<Category> optionList = getCategory(null, 0, Optional.of("50000002"));
            optionList.forEach(l -> {
                System.out.println(l.getName());
                System.out.println(l.getCid());
            });

            optionList = getCategory(new Category("name", "50000002", null), 1, Optional.of("50000195"));
            optionList.forEach(l -> {
                System.out.println(l.getName());
                System.out.println(l.getCid());
            });

            optionList = getCategory(new Category("name", "50000195", null), 2, Optional.empty());
            optionList.forEach(l -> {
                System.out.println(l.getName());
                System.out.println(l.getCid());
            });

            List<String> keywordList = this.getPopularKeyword(Arrays.asList("50000002", "50000195"));
            System.out.println("keywordList => " + keywordList);

            logger.info("Global statistics {}", "weif");

        } catch (KeyNotFoundException keyNotFoundException) {
            logger.error("Exiting application as configured key is not available: {}", keyNotFoundException.toString());
            System.exit(1);
        }
        return "globalStatistics";
    }

    public List<Category> getCategory(Category parent, int index, Optional<String> selectCid) {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        List<WebElement> ulList = webDriver.findElements(By.cssSelector("ul[class='select_list scroll_cst']"));

        if (index > 0) {
            System.out.println("parent => " + parent);
            List<WebElement> optionList = ulList.get(index-1).findElements(By.cssSelector("a[class='option']"));
            optionList.stream().filter(l -> l.getAttribute("data-cid").equals(parent.getCid()))
                    .findFirst()
                    .ifPresent(e -> wait.until(ExpectedConditions.visibilityOf(e)).click());
            System.out.println("index => " + index);
        }

        // 카테고리 버튼 클릭
        List<WebElement> selectBtnList = webDriver.findElements(By.cssSelector("span[class='select_btn']"));

        selectBtnList.get(index).click();

        List<Category> categoryList = new ArrayList<>();

        List<WebElement> optionList = ulList.get(index).findElements(By.cssSelector("a[class='option']"));
        // Actions action = new Actions(webDriver);
        // action.moveToElement(option).perform();
        optionList.forEach(option -> {
            // if (!option.isDisplayed()) {
            //     ulList.get(index).sendKeys(Keys.PAGE_DOWN);
            // }
            // String name = wait.until(ExpectedConditions.visibilityOf(option)).getText();
            String name = option.getText();
            String dataCid = option.getAttribute("data-cid");
            System.out.println(" name : " + name + ", dataCid : " + dataCid);
            // Root 카테고리
            categoryList.add(new Category(name, dataCid, parent));
        });

        if (index == 2) {
            selectBtnList.get(index-1).click();
        }
        /*
        System.out.println("parent => " + parent);
        selectCid.ifPresent(c -> {
            System.out.println("cid => " + c);

            optionList.stream().filter(l -> l.getAttribute("data-cid").equals(c))
                    .findFirst()
                    .ifPresent(e -> wait.until(ExpectedConditions.visibilityOf(e)).click());
        });
         */

        return categoryList;
    }

    private List<String> getPopularKeyword(List<String> cidList) {

        IntStream.range(0, cidList.size()).forEach(index -> {
            List<WebElement> selectBtnList = webDriver.findElements(By.cssSelector("span[class='select_btn']"));
            selectBtnList.get(index).click();

            WebElement ul = webDriver.findElement(By.cssSelector("ul[class='select_list scroll_cst']"));
            List<WebElement> linkList = ul.findElements(By.cssSelector("a[class='option']"));

            String cid = cidList.get(index);
            // 화장품/미용 첫번째 카테고리 선택
            linkList.stream().filter(l -> l.getAttribute("data-cid").equals(cid)).findFirst()
                    .ifPresent(e -> e.click());
        });

        // 검색 시작
        WebElement stepForm = webDriver.findElement(By.cssSelector("div[class='step_form']"));
        WebElement submitBtn = stepForm.findElement(By.cssSelector("a[class='btn_submit']"));
        submitBtn.click();

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul[class='rank_top1000_list']")));

        WebElement pageBtnBox = webDriver.findElement(By.cssSelector("div[class='btn_page_box']"));
        WebElement rankUl = webDriver.findElement(By.cssSelector("ul[class='rank_top1000_list']"));

        List<String> keywordRankList = new ArrayList<>();
        IntStream.range(1, 25).forEach(index -> {

            List<WebElement> keywords = rankUl.findElements(By.cssSelector("a[class='link_text']"));
            List<String> wordList = keywords.stream().map(word -> word.getText()).collect(Collectors.toList());

            keywordRankList.addAll(wordList);

            pageBtnBox.findElement(By.cssSelector("a[class='btn_page_next']")).click();
        });

        return keywordRankList;
    }
}
