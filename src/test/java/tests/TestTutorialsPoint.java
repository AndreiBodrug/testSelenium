package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;

public class TestTutorialsPoint {

    WebDriver driver = new EdgeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void driverMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
    }

    /*@AfterTest
    public void tearDown(){
        driver.quit();
    }*/
    //****************************************************************
    @Test
    public void textBoxTest() throws InterruptedException {

        WebElement fullNameField = driver.findElement(By.id("fullname"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement addressField = driver.findElement(By.id("address"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitField = driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"]"));

        fullNameField.sendKeys("First Name Second Name");
        emailField.sendKeys("someemail@mail.com");
        addressField.sendKeys("Some address");
        passwordField.sendKeys("password");

        Thread.sleep(5000);
        submitField.click();

    }
    //****************************************************************
    @Test
    public void checkBoxTest() throws InterruptedException {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@href=\"check-box.php\"]")));

        WebElement checkBoxSection = driver.findElement(By.xpath("//*[@href=\"check-box.php\"]"));
        checkBoxSection.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("c_bs_1")));

        WebElement checkBoxMainLevel1 = driver.findElement(By.id("c_bs_1"));
        WebElement checkBoxMainLevel2 = driver.findElement(By.id("c_bs_2"));
        Thread.sleep(5000);

        checkBoxMainLevel1.click();
        checkBoxMainLevel2.click();
    }
    //******************************************************************
    @Test
    public void webTableTest() throws InterruptedException{

        //Create an array list which will contain the paths of all fields from "Registration Form" pop-up
        //***********************************************************************************************
        ArrayList<String> registrationFormFields = new ArrayList<>();
        registrationFormFields.add("//*/input[@id=\"firstname\"]");
        registrationFormFields.add("//*/input[@id=\"lastname\"]");
        registrationFormFields.add("//*/input[@id=\"email\"]");
        registrationFormFields.add("//*/input[@id=\"age\"]");
        registrationFormFields.add("//*/input[@id=\"salary\"]");
        registrationFormFields.add("//*/input[@id=\"deparment\"]");
        //************************************************************************************************

        //Wait when "webtables" element appears on the screen.Then find it and click on it
        //*******************************************************************
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@href=\"webtables.php\"]")));
        driver.findElement(By.xpath("//*[@href=\"webtables.php\"]")).click();
        //*******************************************************************

        //Wait when button "Add" appears on the screen. Then find it and click on it
        //****************************************************************************
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/button[@class=\"btn btn-primary\"]")));
        driver.findElement(By.xpath("//*/button[@class=\"btn btn-primary\"]")).click();
        //****************************************************************************

        //Wait when "Registration Form" appears. Then go through all input fields and populate them with data
        //***************************************************************************************************
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[@id=\"staticBackdropLive\"]//*/form[@id=\"RegisterForm\"]")));
        for(String i : registrationFormFields){
            if(i.equals("//*/input[@id=\"email\"]")){
                driver.findElement(By.xpath(i)).sendKeys("test@mail.com");
            }else if(i.equals("//*/input[@id=\"salary\"]")) {
                driver.findElement(By.xpath(i)).sendKeys("12345678901234567890");
            }else{
                driver.findElement(By.xpath(i)).sendKeys("Test");
            }
        }
        //****************************************************************************************************

        //Click on "Login" button
        driver.findElement(By.xpath("//*/input[@type=\"submit\"]")).click();
    }
}
