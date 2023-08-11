package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.CartPage;
import pageObject.homePage;

import java.util.concurrent.TimeUnit;

public class registerAndLoginStepDef {
    public WebDriver driver;
    public homePage hp;
    public CartPage cp;


    @Given("browser is open")
    public void browser_is_open() {

        System.setProperty("webdriver.chrome .driver",System.getProperty("user.dir")+"//drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.demoblaze.com/");
        hp=new homePage(driver);
        cp =new CartPage(driver);
    }
    @And("user is on register page")
    public void user_is_on_register_page() throws InterruptedException {
        hp.clickSignup();
    }
    @When("user enters {string} and {string}")
    public void user_enters_and(String string, String string2) {
        hp.enterusername(string);
        hp.enterpassword(string2);
        hp.click_Signup();
        hp.alertHandle();
    }
    @Then("user is navigated on home page")
    public void user_is_navigated_on_home_page() {
        hp.checkIfUserNvaiatedToHomePage();
    }
    @Given("user is on login page")
    public void user_is_on_login_page() {
        hp.userClickLogin();
    }
    @When("user login {string} and {string}")
    public void user_login_and(String string, String string2) {
        hp.enterLoginusername(string);
        hp.enterLoginpassword(string2);
        hp.user_Clicklogin();

    }
    @Then("check listed categories to the cart")
    public void check_listed_categories_to_the_cart() {
        hp.checkPhoneCat();
        hp.checkLaptopCat();
        hp.checkmonitoreCat();
    }


    @And("close browser")
    public void close_browser(){
        driver.quit();
    }
    @Then("user choose device")
    public void userChooseDevice() throws InterruptedException {
        hp=new homePage(driver);



        hp.userChooseDevice();
    }
    @Then("user click on add cart")
    public void userClickAddToCart(){
        cp=new CartPage(driver);

        cp.userClickAddToCart();
    }
    @Then("user click on cart button")
    public void userClickCarttCo(){
        cp.userClickOnCartBo();
        hp.checkitemAddedTocart();
    }
    @Then("user Click Delete")
    public void userClickDeleteB0(){

        cp.userClickDeleteboo();
        try {
            hp.checkitemdeleted();
        }
        catch (Exception e)
        {
            System.out.println("no more items deleted successfully ");
        }


    }
    @Then("user click checkout")
    public void userClickCheckout(){
        cp.userClickCheckoutBo();
    }
    @And("user enter {string}")
    public void userEnterName(String string){
        cp.user_enter_name(string);
    }
    @And("user enters {string}")
    public void userEnterCountry(String string){
        cp.user_enter_contry(string);
    }
    @And("user fill {string}")
    public void userEnterCity(String string){
        cp.user_enter_city(string);
    }
    @And("user fills {string} and {string} and {string}")
    public void enterCreditDetails(String string,String string1 ,String string2)
    {
        cp.user_enter_creditcard(string);
        cp.user_enter_month(string1);
        cp.user_enter_years(string2);
    }
    @Then("user click purchase")
    public void userClickPurchas(){
        cp.user_click_purchase();
    }
    @Then("user validate success message and press ok")
    public void userchecksuccess(){
        cp.user_check_success();
    }


}
