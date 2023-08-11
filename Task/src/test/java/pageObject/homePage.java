package pageObject;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class homePage {
    public WebDriver driver1;



    public homePage(WebDriver driver2)
    {
        driver1=driver2;
        PageFactory.initElements(driver2,this);
    }
   Duration duration=Duration.ofSeconds(30);
    //int x=10;
//    public WebDriverWait wait=new WebDriverWait(driver1,duration);

    String itemname;
    @FindBy(id = "signin2")
    @CacheLookup
    WebElement signup;

    @FindBy(id="sign-username")
    @CacheLookup
    WebElement username;

    @FindBy(id="loginusername")
    @CacheLookup
    WebElement login_username;

    @FindBy(id="sign-password")
    @CacheLookup
    WebElement password;

    @FindBy(id="loginpassword")
    @CacheLookup
    WebElement login_password;

    @FindBy(xpath="//button[contains(text(),'Sign up')]")
    @CacheLookup
    WebElement sign_up_bo;

    @FindBy(id="nava")
    @CacheLookup
    WebElement logoo;

    @FindBy(id="login2")
    @CacheLookup
    WebElement login;

    @FindBy(xpath = "//a[@class='hrefch']")
    @CacheLookup
    WebElement items;

    @FindBy(xpath = "//a[contains(text(),'Phones')]")
    @CacheLookup
    WebElement phones;

    @FindBy(xpath = "//a[contains(text(),'Laptops')]")
    @CacheLookup
    WebElement laptops;
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginbo;

    @FindBy(xpath = "//a[contains(text(),'Monitors')]")
    @CacheLookup
    WebElement monitors ;

    @FindBy(xpath = "//td[contains(text(),'Samsung galaxy s6')]")
    @CacheLookup
    WebElement CartString;

    public void clickSignup() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver1,duration);
         wait.until(ExpectedConditions.visibilityOf(signup));
       // Thread.sleep(3000);
        signup.click();
    }
    public void enterusername(String user_name){
        WebDriverWait wait=new WebDriverWait(driver1,duration);
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(user_name);
    }
    public void enterpassword(String passsword){
        WebDriverWait wait=new WebDriverWait(driver1,duration);
       wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(passsword);
    }
    public void click_Signup()
    {
        WebDriverWait wait=new WebDriverWait(driver1,duration);
        wait.until(ExpectedConditions.visibilityOf(sign_up_bo));
        sign_up_bo.click();
    }
    public void alertHandle(){
        WebDriverWait wait=new WebDriverWait(driver1,duration);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver1.switchTo().alert();
        alert.accept();
    }
    public void checkIfUserNvaiatedToHomePage(){
        WebDriverWait wait=new WebDriverWait(driver1,duration);
        wait.until(ExpectedConditions.visibilityOf(logoo));
        logoo.isDisplayed();
    }
    public void userClickLogin(){
        WebDriverWait wait=new WebDriverWait(driver1,duration);
        wait.until(ExpectedConditions.visibilityOf(login));
        login.click();

    }
    public void enterLoginusername(String user_name){
        WebDriverWait wait=new WebDriverWait(driver1,duration);
        wait.until(ExpectedConditions.visibilityOf(login_username));
        login_username.sendKeys(user_name);
    }
    public void enterLoginpassword(String passsword){
        WebDriverWait wait=new WebDriverWait(driver1,duration);
        wait.until(ExpectedConditions.visibilityOf(login_password));
        login_password.sendKeys(passsword);
    }
    public void user_Clicklogin(){
   loginbo.click();
    }
    public void checkPhoneCat(){
        try{
            phones.click();
            WebDriverWait wait=new WebDriverWait(driver1,duration);
           wait.until(ExpectedConditions.visibilityOf(items));
            items.isDisplayed();
        }

        catch (Exception e)
        {
            System.out.println("No item found");
        }
    }
    public void checkLaptopCat(){
        try{
            laptops.click();

            WebDriverWait wait=new WebDriverWait(driver1,duration);
            wait.until(ExpectedConditions.visibilityOf(items));
            items.isDisplayed();
        }

        catch (Exception e)
        {
            System.out.println("No item found");
        }
    }
    public void checkmonitoreCat(){
        try{
            monitors.click();
            WebDriverWait wait=new WebDriverWait(driver1,duration);
            wait.until(ExpectedConditions.visibilityOf(items));
            items.isDisplayed();
        }

        catch (Exception e)
        {
            System.out.println("No item found");
        }
    }
    public void userChooseDevice() throws InterruptedException {
        Thread.sleep(3000);

        List<WebElement> device=driver1.findElements(By.xpath("//a[@class='hrefch']"));
        itemname=device.get(0).getText();
        device.get(0).click();
    }

    public void checkitemAddedTocart(){
        Assert.assertEquals(itemname,CartString.getText());
    }
    public void checkitemdeleted(){
        Assert.assertNotEquals(itemname,CartString.getText());
    }



}
