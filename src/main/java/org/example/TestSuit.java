package org.example;


import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class TestSuit {

    protected static WebDriver driver;


        //*****************************[BEFORE METHOD]******************************************************************
        @BeforeMethod

        public void openBrowser() {
          System.setProperty("webdriver.chrome.driver", "src/main/java/Drivers/chromedriver.exe");
          driver = new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
          driver.manage().window().maximize();
          driver.get("https://demo.nopcommerce.com/");
        }
        //****************************[REGISTRATION TASK]***************************************************************
        @Test

        public void userShouldBeAbleToRegisterSuccessfully() {

            //click on register button
            Clickonelements(By.className("ico-register"));

            //select gender
            driver.findElement(By.xpath("//input[@id='gender-female']"));

            //First Name
            texttype(By.xpath("//input[@id='FirstName']"), "Automation");

            //Last Name
            texttype(By.id("LastName"), "LastNameTest");

            //select date of birth
            driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
            Select birthday = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
            birthday.selectByVisibleText("3");

            //select month of year
            driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
            Select birthmonth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
            birthmonth.selectByVisibleText("January");

            //select year
            driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
            Select birthyear = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
            birthyear.selectByVisibleText("2015");

            //Enter Email
            texttype(By.id("Email"),"fhhht1" + randomDate() + "@yahoo.com");

            //Password
            texttype(By.id("Password"), "ABC123");

            //Confirm Password
            texttype(By.id("ConfirmPassword"), "ABC123");

            //click register button
            Clickonelements(By.id("register-button"));

             String expectedMessage = "Your registration completed";
             String actualMessage=driver.findElement(By.className("result")).getText();
             Assert.assertEquals(expectedMessage,actualMessage,"registration is not successful");
        }
        //****************************[---HOMEWORK TASK 1---]***********************************************************

        @Test
        public void userShouldBeAbleToAddProductInTheShoppingBasketSuccessfully() {

        //click on computers
        Clickonelements(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

        //click on desktops
        Clickonelements(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));

        //click on build your own computer
        Clickonelements(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']"));

        //click on processor and select 2.2Ghz
        driver.findElement(By.xpath("//select[@id='product_attribute_1']"));
        Select processor = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_1']")));
        processor.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

        //click on Ram and select 2gb
        driver.findElement(By.xpath("//label[contains(text(),'RAM')]"));
        Select ram = new Select(driver.findElement(By.xpath("//select[@id='product_attribute_2']")));
        ram.selectByVisibleText("2 GB");

        //select320gb
        Clickonelements(By.xpath("//input[@id='product_attribute_3_6']"));

        //select vistahome from OS
         Clickonelements(By.xpath("//input[@id='product_attribute_4_8']"));

        //select software microsoftoffice
         Clickonelements(By.xpath("//input[@id='product_attribute_5_10']"));

        //select software Acrobat reader
         Clickonelements(By.xpath("//input[@id='product_attribute_5_11']"));

        //select Total commander
        Clickonelements(By.xpath("//input[@id='product_attribute_5_12']"));

        //click on add to cart button
        Clickonelements(By.xpath("//button[@id='add-to-cart-button-1']"));
         //   driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //to verify the product is in the basket
         driver.findElement(By.xpath("//span[@class=\"cart-label\"]")).click();

         assertEquals("Shopping cart",By.xpath("//div[@class='page-title']"),"shopping cart locator not found");
         assertEquals("Build your own computer",By.xpath("//a[@class='product-name']"),"Empty basket");

       // String expectedMessage="The product has been added to your shopping cart";
       // String actualMessage=driver.findElement(By.xpath("//p[@class='content']")).getText();
        //        Assert.assertEquals(actualMessage,expectedMessage,"Product has not been added to your cart");

        //String expectedMessage="The product has been added to your shopping cart";
       // String actualMessage=driver.findElement(By.xpath("//p[@class='content']")).getText();
        //Assert.assertEquals(actualMessage,expectedMessage,"The product has not been added to cart");

    }

        //******************************[---HOMEWORK TASK 2---]********************************************************
        @Test
        public void userShouldBeAbleToSendEmailToAFriend()
           {

            //click on register button
            Clickonelements(By.className("ico-register"));

            //select gender
            Clickonelements(By.xpath("//input[@id='gender-female']"));

            //Enter First Name
            texttype(By.xpath("//input[@id='FirstName']"), "Automation");

            //Enter Last Name
            texttype(By.id("LastName"), "LastNameTest");

            //select date of birth
            driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
            Select birthday = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
            birthday.selectByVisibleText("3");

            //select month of year
            driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
            Select birthmonth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
            birthmonth.selectByVisibleText("January");

            //select Birth year
            driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
            Select birthyear = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
            birthyear.selectByVisibleText("2015");

            //Enter Email address
            texttype(By.id("Email"),"fhhht1" + randomDate() + "@yahoo.com");

            //Enter Password
            texttype(By.id("Password"), "ABC123");

            //Confirm Password
            texttype(By.id("ConfirmPassword"), "ABC123");

            //click register button
            Clickonelements(By.id("register-button"));

            //click on computer
            Clickonelements(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));

            //click on desktop
            Clickonelements(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));

            //click on Build your own computer
            Clickonelements(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']"));

            //click on email a friend
            Clickonelements(By.xpath("//button[normalize-space()='Email a friend']"));

            //enter friend's email
            texttype(By.xpath("//input[@id='FriendEmail']"), "abcd@gmail.com");

            //click on send email button
            Clickonelements(By.xpath("//button[contains(text(),'Send email')]"));

            //check the Result
            String expected="Your message has been sent.";
            String actualMessage=driver.findElement(By.xpath("//div[@class='result']")).getText();
            Assert.assertEquals(expected,actualMessage,"Message has not been sent successfully");





        }
       //*******************************[---HOMEWORK TASK 3---]********************************************************
        @Test
        public void userShouldBeAbleToSelectCurruncyInEuro()
        {
        //click on currency bar
        Clickonelements(By.id("customerCurrency"));

        //select currency
        Select currency=new Select(driver.findElement(By.id("customerCurrency")));
        currency.selectByVisibleText("Euro");

        //scroll down on homepage,build your own computer to check the price
        //user should be able to see "€"in front of the price

        //Expected and Actual Check
        String expectedCurrency="€1032.00";
        String actualCurrency=driver.findElement(By.xpath("//span[contains(text(),'€1032.00')]")).getText();
        Assert.assertEquals(actualCurrency,expectedCurrency,"€ sign not in front of the price");
        }

        //***************************[AFTER METHOD]*********************************************************************
        @AfterMethod
        public void closeBrowser()
        {
        driver.quit();
        }

       //********************************[METHODS TO REUSE]*************************************************************


           public static void Clickonelements(By by)
        {
           driver.findElement(by).click();
        }
           public static void texttype(By by,String text)
        {
            driver.findElement(by).sendKeys(text);
        }
           public static String Gettextfrom(By by)
        {
           return driver.findElement(by).getText();
        }
           public static void driverWaitsUntilURL(int time,String url){
           WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
           wait.until(ExpectedConditions.elementToBeClickable(By.id(url)));
        }
           public static String randomDate()
        {
           Date date = new Date();
           SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
           return formatter.format(date);
        }
          public static void assertEquals(String expectedMessage,By by, String errormessage){
           String expectedmessage="expectedMessage";
           String actualMessage=driver.findElement(by).getText();
           Assert.assertEquals(actualMessage,expectedMessage,"errormessage");}

       //**************************************[WAIT METHODS]**************************************************************


    public static void driverWaitUntilElementToBeClickable(By by,int time)
    {
        WebDriverWait wait01=new WebDriverWait(driver,Duration.ofSeconds(time));
        wait01.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void driverWaitUntilElementContainersUrlFraction(By by,int time,String FractionUrl)
    {
        WebDriverWait wait02=new WebDriverWait(driver,Duration.ofSeconds(time));
        wait02.until(ExpectedConditions.urlContains("FractionUrl"));
    }
    public static void driverWaitUntilElementLocated(By by,int time)
    {
        WebDriverWait wait03=new WebDriverWait(driver,Duration.ofSeconds(time));
        wait03.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static void driverWaitUntilContainersUrl(int time,String url)
    {
        WebDriverWait wait04= new WebDriverWait(driver,Duration.ofSeconds(time));
        wait04.until(ExpectedConditions.urlContains(url));
    }
    public static void driverWaitUntilElementsTitleContains(By by,int time,String TitleContains)
    {
        WebDriverWait wait05=new WebDriverWait(driver,Duration.ofSeconds(time));
        wait05.until(ExpectedConditions.titleContains(TitleContains));
    }
    public static void driverWaitUntilPresenceOfElement(By by,int time)
    {
        WebDriverWait wait06=new WebDriverWait(driver,Duration.ofSeconds(time));
        wait06.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    public static void driverWaitUntilInvisibilityOfWebElement(int time, WebElement element)
    {
        WebDriverWait wait07=new WebDriverWait(driver,Duration.ofSeconds(time));
        wait07.until(ExpectedConditions.invisibilityOf(element));
    }
    public static void driverWaitUntilAtributeToBe(int time,By by,String atribute, String text  )
    {
        WebDriverWait wait08=new WebDriverWait(driver,Duration.ofSeconds(time));
        wait08.until(ExpectedConditions.attributeContains(by,atribute,text ));
    }
    public static void driverWaitUntilAlertPresent(int time)
    {
        WebDriverWait wait09=new WebDriverWait(driver,Duration.ofSeconds(time));
        wait09.until(ExpectedConditions.alertIsPresent());
    }
    public static void driverWaitUntilAttributeToBeNotEmpty(int time,WebElement element,String attribute)
    {
        WebDriverWait wait10=new WebDriverWait(driver,Duration.ofSeconds(time));
        wait10.until(ExpectedConditions.attributeToBeNotEmpty(element,attribute));
    }
    //******************************************************************************************************************


}