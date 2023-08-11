package pageObject;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    public WebDriver driver1;



    public CartPage(WebDriver driver2)
    {
        driver1=driver2;
        PageFactory.initElements(driver2,this);
    }
    Duration duration=Duration.ofSeconds(30);
    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    WebElement AddToCartBo;
    @FindBy(id = "cartur")
    WebElement cartbo;
    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    WebElement delebo;
    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement checkoutbo;
    @FindBy(id = "name")
    WebElement namee;
    @FindBy(id = "country")
    WebElement country1;
    @FindBy(id = "city")
    WebElement cityy;
    @FindBy(id = "card")
    WebElement creditcardd;
    @FindBy(id = "month")
    WebElement montH;
    @FindBy(id = "year")
    WebElement yeaR;
    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    WebElement purchase;
    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
    WebElement confirmation_message;
            @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
            WebElement okButton;



    public void userClickAddToCart(){
        WebDriverWait wait=new WebDriverWait(driver1,duration);
        wait.until(ExpectedConditions.visibilityOf(AddToCartBo));
        AddToCartBo.click();
    }
    public void userClickOnCartBo(){
        WebDriverWait wait=new WebDriverWait(driver1,duration);
        wait.until(ExpectedConditions.visibilityOf(cartbo));
        cartbo.click();

    }
    public void userClickDeleteboo(){
        WebDriverWait wait=new WebDriverWait(driver1,duration);
        wait.until(ExpectedConditions.visibilityOf(delebo));
        delebo.click();

    }
    public void userClickCheckoutBo(){
        checkoutbo.click();
    }
    public void user_enter_name(String name){
        WebDriverWait wait=new WebDriverWait(driver1,duration);
        wait.until(ExpectedConditions.visibilityOf(namee));

        namee.sendKeys(name);
    }
    public void user_enter_contry(String country){
        country1.sendKeys(country);
    }
    public void user_enter_city(String city){
        cityy.sendKeys(city);
    }
    public void user_enter_creditcard(String creditcard){
        creditcardd.sendKeys(creditcard);
    }
    public void user_enter_month(String month){
        montH.sendKeys(month);
    }
    public void user_enter_years(String year){
        yeaR.sendKeys(year);
    }
    public void user_click_purchase(){
        JavascriptExecutor js = (JavascriptExecutor) driver1;
        js.executeScript("window.scrollBy(0,100)");
        purchase.click();
    }
    public void user_check_success(){
        WebDriverWait wait=new WebDriverWait(driver1,duration);
        wait.until(ExpectedConditions.visibilityOf(confirmation_message));

        Assert.assertEquals("Thank you for your purchase!",confirmation_message.getText());
        okButton.click();
    }

}
