package homepage;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {
    String baseUrl= "https://mobile.x-cart.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully(){

        clickOnElement(By.xpath("(//span[contains(text(),'Shipping')])[2]"));
        verifyText("Shipping",By.xpath("//h1[contains(text(),'Shipping')]"),"Error, Message not displayed as expected");
    }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        clickOnElement(By.xpath("(//span[contains(text(),'New!')])[2]"));
        verifyText("New arrivals",By.xpath("//h1[contains(text(),'New arrivals')]"),"Error, Message not displayed as expected");
    }

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully(){
        clickOnElement(By.xpath("(//span[contains(text(),'Coming soon')])[2]"));
        verifyText("Coming soon",By.xpath("//h1[contains(text(),'Coming soon')]"),"Error, Message not displayed as expected");
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        clickOnElement(By.xpath("(//span[contains(text(),'Contact us')])[2]"));
        verifyText("Contact us",By.xpath("//h1[contains(text(),'Contact us')]"),"Error, Message not displayed as expected");
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
