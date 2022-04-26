package hotdeals;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class HotDealsTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void openBrowser(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyText("Sale", By.xpath("//h1[contains(text(),'Sale')]"), "Error, Message not displayed as expected");
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name A - Z')]"));
        verifyText("Name A - Z", By.xpath("//span[contains(text(),'Name A - Z')]"), "Error, Message not displayed as expected");
    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyText("Sale", By.xpath("//h1[contains(text(),'Sale')]"), "Error, Message not displayed as expected");
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Price Low - High')]"));
        verifyText("Price Low - High", By.xpath("//span[contains(text(),'Price Low - High')]"), "Error, Message not displayed as expected");
    }

    @Test
    public void vefirySalesProductsArrangedByRates() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyText("Sale", By.xpath("//h1[contains(text(),'Sale')]"), "Error, Message not displayed as expected");
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Rates')]"));
        verifyText("Rates", By.xpath("//span[contains(text(),'Rates')]"), "Error, Message not displayed as expected");
    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyText("Bestsellers", By.xpath("//h1[contains(text(),'Bestsellers')]"), "Error, Message not displayed as expected");
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name Z - A')]"));
        verifyText("Name Z - A", By.xpath("//span[contains(text(),'Name Z - A')]"), "Error, Message not displayed as expected");
    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyText("Bestsellers", By.xpath("//h1[contains(text(),'Bestsellers')]"), "Error, Message not displayed as expected");
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Price High - Low')]"));
        verifyText("Price High - Low", By.xpath("//span[contains(text(),'Price High - Low')]"), "Error, Message not displayed as expected");
    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyText("Bestsellers", By.xpath("//h1[contains(text(),'Bestsellers')]"), "Error, Message not displayed as expected");
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Rates')]"));
        verifyText("Rates", By.xpath("//span[contains(text(),'Rates')]"), "Error, Message not displayed as expected");
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
