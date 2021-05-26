package com.asc.als.scrapper;

import com.asc.als.scrapper.service.NaverDatalabScrapperService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NaverDatalabSeleniumTests { // } extends BaseSeleniumTests {

    @Inject
    private WebDriver webDriver;

    @Inject
    private NaverDatalabScrapperService naverDatalabScrapper;

    /*
    public GoogleSearchPageTraditionalSeleniumTests(NaverDatalabScrapperService naverDatalabScrapperService) {
        this.naverDatalabScrapperService = naverDatalabScrapperService;
    }
     */

    @Test
    public void getSearchPage() {
        webDriver.get("https://www.google.com");
        WebElement element = webDriver.findElement(By.name("q"));
        assertNotNull(element);
    }

    @Test
    public void getShoppingInsightPage() {
        this.naverDatalabScrapper.navigate("https://datalab.naver.com/shoppingInsight/sCategory.naver");
        this.naverDatalabScrapper.scrape();

        /*
        webDriver.get("https://datalab.naver.com/shoppingInsight/sCategory.naver");

        // 첫번째 카테고리 버튼
        WebElement select_btn = webDriver.findElement(By.cssSelector("span[class='select_btn']"));
        select_btn.click();

        WebElement ul = webDriver.findElement(By.cssSelector("ul[class='select_list scroll_cst']"));
        List<WebElement> linkList = ul.findElements(By.cssSelector("a[class='option']"));
        linkList.forEach(l -> {
            System.out.println(l.getText());
            System.out.println(l.getAttribute("data-cid"));
        });

        // 화장품/미용 첫번째 카테고리 선택
        linkList.stream().filter(l -> l.getAttribute("data-cid").equals("50000002")).findFirst()
                .ifPresent(e -> e.click());


        System.out.println("+++++++++++++++++++++++++++ 두번째 카테고리 +++++++++++++++++++++++");
        // 두번째 카테고리 버튼
        List<WebElement> selectBtnList = webDriver.findElements(By.cssSelector("span[class='select_btn']"));
        selectBtnList.get(1).click();

        List<WebElement> ulList = webDriver.findElements(By.cssSelector("ul[class='select_list scroll_cst']"));
        linkList = ulList.get(1).findElements(By.cssSelector("a[class='option']"));
        linkList.forEach(l -> {
            System.out.println(l.getText());
            System.out.println(l.getAttribute("data-cid"));
        });

        // 색조메이크업 두번째 카테고리 선택
        linkList.stream().filter(l -> l.getAttribute("data-cid").equals("50000195")).findFirst()
                .ifPresent(e -> e.click());


        System.out.println("+++++++++++++++++++++++++++ 세번째 카테고리 +++++++++++++++++++++++");
        // 세번째 카테고리 버튼
        selectBtnList = webDriver.findElements(By.cssSelector("span[class='select_btn']"));
        selectBtnList.get(2).click();

        ulList = webDriver.findElements(By.cssSelector("ul[class='select_list scroll_cst']"));
        linkList = ulList.get(2).findElements(By.cssSelector("a[class='option']"));
        linkList.forEach(l -> {
            System.out.println(l.getText());
            System.out.println(l.getAttribute("data-cid"));
        });
         */
    }

    @Test
    public void getPopularSearchKeyword() {
        webDriver.get("https://datalab.naver.com/shoppingInsight/sCategory.naver");

        // 첫번째 카테고리 버튼
        WebElement select_btn = webDriver.findElement(By.cssSelector("span[class='select_btn']"));
        select_btn.click();

        WebElement ul = webDriver.findElement(By.cssSelector("ul[class='select_list scroll_cst']"));
        List<WebElement> linkList = ul.findElements(By.cssSelector("a[class='option']"));

        // 화장품/미용 첫번째 카테고리 선택
        linkList.stream().filter(l -> l.getAttribute("data-cid").equals("50000002")).findFirst()
                .ifPresent(e -> e.click());


        System.out.println("+++++++++++++++++++++++++++ 두번째 카테고리 +++++++++++++++++++++++");
        // 두번째 카테고리 버튼
        List<WebElement> selectBtnList = webDriver.findElements(By.cssSelector("span[class='select_btn']"));
        selectBtnList.get(1).click();

        List<WebElement> ulList = webDriver.findElements(By.cssSelector("ul[class='select_list scroll_cst']"));
        linkList = ulList.get(1).findElements(By.cssSelector("a[class='option']"));

        // 색조메이크업 두번째 카테고리 선택
        linkList.stream().filter(l -> l.getAttribute("data-cid").equals("50000195")).findFirst()
                .ifPresent(e -> e.click());


        System.out.println("+++++++++++++++++++++++++++ 세번째 카테고리 +++++++++++++++++++++++");
        // 세번째 카테고리 버튼
        selectBtnList = webDriver.findElements(By.cssSelector("span[class='select_btn']"));
        selectBtnList.get(2).click();

        ulList = webDriver.findElements(By.cssSelector("ul[class='select_list scroll_cst']"));
        linkList = ulList.get(2).findElements(By.cssSelector("a[class='option']"));

        // 블러셔 번째 카테고리 선택
        linkList.stream().filter(l -> l.getAttribute("data-cid").equals("50000399")).findFirst()
                .ifPresent(e -> e.click());

        // 검색 시작
        WebElement stepForm = webDriver.findElement(By.cssSelector("div[class='step_form']"));
        WebElement submitBtn = stepForm.findElement(By.cssSelector("a[class='btn_submit']"));
        submitBtn.click();

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul[class='rank_top1000_list']")));

        WebElement rankUl = webDriver.findElement(By.cssSelector("ul[class='rank_top1000_list']"));
        List<WebElement> keywords = rankUl.findElements(By.cssSelector("a[class='link_text']"));
        keywords.forEach(word -> {
            System.out.println("keyword : " + word.getText());
            System.out.println("keyword : " + word.getAttribute("href"));
        });
    }
}
