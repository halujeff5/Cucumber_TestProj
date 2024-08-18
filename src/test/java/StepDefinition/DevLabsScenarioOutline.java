package StepDefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class DevLabsScenarioOutline {

    public WebDriver driver;
    public String parent;

    //helps to generate the logs in the test report.

    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private ExtentTest logger;


    @Before
    public void user_launch_docker_application() {
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/jeffreyng/Downloads/chromedriver-mac-arm64/chromedriver");
            driver = new ChromeDriver(); //initialization of chromedriver
            driver.get("https://www.docker.com"); //this will give the docker URL in chrome browser
            driver.manage().window().maximize(); //this line will maximize the window
            Thread.sleep(5000);
            // initialize the HtmlReporter

            // Create an object of Extent Reports
            extent = new ExtentReports();

            spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Report_HomePagePlan.html");
            extent.attachReporter(spark);
            extent.setSystemInfo("Host Name", "Docker Application - Home Plan");
            extent.setSystemInfo("Environment", "Production");
            extent.setSystemInfo("User Name", "Test Team");
            spark.config().setDocumentTitle("Docker_Application_testNG Application QA ");
            // Name of the report
            spark.config().setReportName("Docker Application Using Selenium testNG ");
            // Dark Theme
            spark.config().setTheme(Theme.STANDARD);
            logger = extent.createTest("Validate Docker Application Using Selenium testNG");

        }catch(Exception e){e.printStackTrace();}

    }
    @When("user validate docker home page title as {string}")
    public void user_validate_docker_home_page_title_as(String expectedtitle) {
        try {

            Assert.assertEquals(expectedtitle, driver.getTitle());
            logger.pass("Docker Title is expected as: " +driver.getTitle());

        }catch(Exception e){e.printStackTrace();}
    }


    @Then("user validate header menu as option as {string}")
    public void user_validate_header_menu_as_option_as(String string) {

    }
    @Then("user validate Sign In button")
    public void user_validate_sign_in_button() {
        //Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed());
    }
    @Then("user validate Get Started button")
    public void user_validate_get_started_button() {
       // Assert.assertTrue(driver.findElement(By.xpath("")).isDisplayed());
    }
    @Then("user scroll to footer section")
    public void user_scroll_to_footer_section() {

    }
    @Then("user validate all social media options")
    public void user_validate_all_social_media_options() {
        try {
            WebElement twitter = driver.findElement(By.xpath("//img[@alt='twitter logo']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", twitter);
            Thread.sleep(5000);
        }catch(Exception e){e.printStackTrace();}

    }
    @Then("user clicks on twitter logo")
    public void user_clicks_on_twitter_logo() {
        parent=driver.getWindowHandle();
        WebElement twitter = driver.findElement(By.xpath("//img[@alt='twitter logo']"));
        twitter.click();
        logger.pass("In footer section, Docker logo is present");
    }
    @Then("user validate URL is having text as {string}")
    public void user_validate_url_is_having_text_as(String twitterURL) {
        try {
            Thread.sleep(5000);
            // It will return the parent window name as a String

            Set<String> s=driver.getWindowHandles();

// Now iterate using Iterator
            Iterator<String> I1= s.iterator();

            while(I1.hasNext())
            {

                String child_window=I1.next();


                if(!parent.equals(child_window))
                {
                    driver.switchTo().window(child_window);

                    System.out.println(driver.switchTo().window(child_window).getTitle());
                    Assert.assertTrue(driver.getCurrentUrl().contains(twitterURL));
                    logger.pass("Twitter URL docker text is present as: "+ driver.getCurrentUrl());
                }

            }
//switch to the parent window


        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Then("user close twitter child tab")
    public void user_close_twitter_child_tab() {
        try {

            driver.close();
            Thread.sleep(5000);
            driver.switchTo().window(parent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void close_docker_application() {

        driver.quit();
        logger.pass("User successfully closed the application.");
        extent.flush();
    }
}
