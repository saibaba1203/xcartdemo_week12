package shopping;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengersFabrikationsPlush() throws InterruptedException {

        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyText("Sale", By.xpath("//h1[contains(text(),'Sale')]"), "Error, Message not displayed as expected");
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name A - Z')]"));
        Thread.sleep(2000);
        mouseHover(By.xpath("//a[@class='product-thumbnail next-previous-assigned']"));
//        Thread.sleep(2000);
        mouseHoverAndClick(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]"));
        verifyText("Product has been added to your cart", By.xpath("//li[@class='info']"), "Error, Message not displayed as expected");
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));
        verifyText("Your shopping cart - 1 item", By.xpath("//h1[contains(text(),'Your shopping cart - 1 item')]"), "Error, Message not displayed as expected");
        sendKeysToElement(By.xpath("//input[contains(@id, 'amount16')]"), Keys.BACK_SPACE + "2");
//        Thread.sleep(3000);
        verifyText("Your shopping cart - 2 items", By.xpath("//h1[contains(text(),'Your shopping cart - 2 items')]"), "Error, Message not displayed as expected");
        verifyText("29", By.xpath("//ul[@class='sums']//span[@class='part-integer'][normalize-space()='29']"), "Error, Message not displayed as expected");
        verifyText("98", By.xpath("//ul[@class='sums']//span[@class='part-decimal'][normalize-space()='98']"), "Error, Message not displayed as expected");
        verifyText("36", By.xpath("//span[contains(text(),'36')]"), "Error, Message not displayed as expected");
        verifyText("00", By.xpath("//span[contains(text(),'00')]"), "Error, Message not displayed as expected");
        clickOnElement(By.xpath("//span[contains(text(),'Go to checkout')]"));
        verifyText("Log in to your account", By.xpath("//h3[contains(text(),'Log in to your account')]"), "Error, Message not displayed as expected");
        sendTextToElement(By.id("email"), getRandomEmail());
        clickOnElement(By.xpath("//span[contains(text(),'Continue')]"));
        verifyText("Secure Checkout", By.xpath("//h1[contains(text(),'Secure Checkout')]"), "Error, Message not displayed as expected");
        sendTextToElement(By.id("shippingaddress-firstname"), "Peter");
        sendTextToElement(By.id("shippingaddress-lastname"), "Patel");
        sendTextToElement(By.id("shippingaddress-street"), "10 Downing Street");
        sendKeysToElement(By.xpath("//input[@id='shippingaddress-city']"), Keys.CLEAR + "London");
        selectByVisibleTextFromDropdown(By.id("shippingaddress-country-code"), "United Kingdom");
        sendTextToElement(By.id("shippingaddress-custom-state"), "West Sussex");
        sendTextToElement(By.id("shippingaddress-zipcode"), "1");
        clickOnElement(By.id("create_profile"));
        sendTextToElement(By.id("password"), "abc123");
        clickOnElement(By.id("method128"));
        clickOnElement(By.id("pmethod6"));
        verifyText("Place order: $37.03", By.xpath("//span[contains(text(),'$37.03')]"), "Error, Total amount not displayed as expected");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']"));
        Thread.sleep(2000);
        verifyText("Thank you for your order", By.id("page-title"), "Error, Page Title not displayed as expected");
    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyText("Bestsellers", By.xpath("//h1[contains(text(),'Bestsellers')]"), "Error, Message not displayed as expected");
        mouseHover(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverAndClick(By.xpath("//a[contains(text(),'Name A - Z')]"));
        Thread.sleep(3000);
        mouseHover(By.xpath("//a[@class='product-thumbnail next-previous-assigned']"));
        mouseHoverAndClick(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-13')]"));
        verifyText("Product has been added to your cart", By.xpath("//li[@class='info']"), "Error, Message not displayed as expected");
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));
        verifyText("Your shopping cart - 1 item", By.xpath("//h1[@id='page-title']"), "Error, Message not displayed as expected");
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));
        Thread.sleep(2000);
        String message = getTextFromAlert();
        verifyMessageText("Are you sure you want to clear your cart?", message, "Error, Message not displayed as expected");
        Thread.sleep(500);
        acceptAlert();
        Thread.sleep(2000);
        verifyText("Item(s) deleted from your cart", By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]\n"), "Error, Message not displayed as expected");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[@title='Close']"));
        Thread.sleep(1000);
        verifyText("Your cart is empty", By.xpath("//h1[contains(text(),'Your cart is empty')]"), "Error, Message not displayed as expected");

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
