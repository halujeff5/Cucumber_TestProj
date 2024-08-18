package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class devlab {
    public WebDriver driver;

    @When("user launch devlab application")
    public void user_launch_devlab_application() {
        System.out.println("i am doing changes for demo branch");
        System.out.println("another file change");
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/jeffreyng/Downloads/chromedriver-mac-arm64/chromedriver");
            driver = new ChromeDriver(); //initialization of chromedriver
            driver.get("http://www.devlabsalliance.com"); //this will give the docker URL in chrome browser
            driver.manage().window().maximize(); //this line will maximize the window
            Thread.sleep(5000);
        }catch(Exception e){e.printStackTrace();}

    }
    @Then("user should navigate to homepage")
    public void user_should_navigate_to_homepage() {
        try {
            driver.findElement(By.xpath("//img[@alt='DevLabs Alliance Logo']")).isDisplayed();
        }catch(Exception e){e.printStackTrace();}
    }
    @Then("user validate devlab logo")
    public void user_validate_devlab_logo() {
        try {
            driver.findElement(By.xpath("//img[@alt='DevLabs Alliance Logo']")).isDisplayed();
        }catch(Exception e){e.printStackTrace();}
    }
    @Then("user validate top menu options")
    public void user_validate_top_menu_options() {
            try {
                driver.findElement(By.xpath("//span[text()='Courses']")).isDisplayed();
                driver.findElement(By.xpath("//button[text()='Consulting']")).isDisplayed();
                driver.findElement(By.xpath("//button[text()='Enterprises']")).isDisplayed();
                driver.findElement(By.xpath("//button[text()='Certification']")).isDisplayed();
                driver.findElement(By.xpath("//button[text()='Resources']")).isDisplayed();
            }catch(Exception e){e.printStackTrace();}
        }



        @When("user clicks on Login button")
        public void user_clicks_on_login_button() {
            try{
                driver.findElement(By.xpath("//button[text()='Log in']")).click();
            }catch(Exception e){e.printStackTrace();}

        }
        @Then("user fills in username and email")
        public void user_fills_in_username_and_email() {
            try {
                driver.findElement(By.xpath("//input[@name='mail']")).sendKeys();
                driver.findElement(By.xpath("//input[@name='password']")).sendKeys();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//    @Then("user submits info")
//    public void user_submits_info() {
//
//    }
//    @Then("server validates info")
//    public void server_validates_info() {
//
//    }

        @Then("user close devlab application")
        public void user_close_devlab_application() {
            driver.quit();
        }}



