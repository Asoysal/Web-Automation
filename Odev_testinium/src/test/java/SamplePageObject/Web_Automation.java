package SamplePageObject;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;






public class Web_Automation  extends BaseClass {


    @Test

    public void loginthewebsite() {


        driver.get("https://www.gittigidiyor.com/");
        String url = driver.getCurrentUrl();    //get the title of the webpage
        System.out.println("The url of this page is ===> " + url);
        Assert.assertEquals("https://www.gittigidiyor.com/", url);    //verify the title of the webpage
        System.out.println("Successfully opened MainPage" );


        driver.get("https://www.gittigidiyor.com/uye-girisi");

        driver.findElement(By.id("L-UserNameField")).clear();//clear the input field before entering any value
        driver.findElement(By.id("L-UserNameField")).sendKeys("alper.soysal@hotmail.com");//enter the value of username
        driver.findElement(By.id("L-PasswordField")).clear();
        driver.findElement(By.id("L-PasswordField")).sendKeys("13261326");//enter the value of password
        driver.findElement(By.id("gg-login-enter")).click();


        //check the login
        String expectedUrl_login = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl_login, expectedUrl_login);

         System.out.println("Successfully logged in"); 

        // search for "bilgisayar"
        driver.findElement(By.xpath("//input[@class = 'sc-4995aq-0 sc-14oyvky-0 itMXHg']")).clear();
        driver.findElement(By.xpath("//input[@class = 'sc-4995aq-0 sc-14oyvky-0 itMXHg']")).sendKeys("bilgisayar");

        driver.findElement(By.xpath("//button[@class = 'qjixn8-0 sc-1bydi5r-0 hKfdXF']")).click();

        // open the second page and check

        // scroll down the page untıl bottom. open the second page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement element_page2_button = driver.findElement(By.linkText("2"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(element_page2_button).click().perform();


        // check the second page
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("2")));

        String expectedUrl_second = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl_second, expectedUrl_second);

        System.out.println("Successfully opened page 2");


        // save the before price

        js.executeScript("window.scrollBy(0,1000)");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[3]/div[2]/ul/li[6]/a/div/div/div[1]/div[2]/div/div[1]/div/div/div[4]/p")));
        String beforeprice = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[3]/div[2]/ul/li[6]/a/div/div/div[1]/div[2]/div/div[1]/div/div/div[4]/p")).getText();
        System.out.println("price in second page price:" + beforeprice);

        // select random product   
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[4]/div[2]/div/div[2]/div[3]/div[2]/ul/li[6]/a/div/div/div[1]/div[1]/h3/span")));
        WebElement element3 = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[3]/div[2]/ul/li[6]/a/div/div/div[1]/div[1]/h3/span"));
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click()", element3);

         // save the after price
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sp-price-lowPrice']")));
         String afterprice = driver.findElement(By.xpath("//div[@id='sp-price-lowPrice']")).getText();
         System.out.println(" price in product page:" +afterprice);

         //random product add to basket
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id = 'add-to-basket']")));
         driver.findElement( By.xpath("//button[@id = 'add-to-basket']")).click();

          // check the price
          Assert.assertEquals(afterprice, beforeprice);
          System.out.println("Price is Matched");

           // add 1 more product
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[3]/div/a")));
           driver.findElement( By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[3]/div/a")).click();

           driver.navigate().back() ;
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id = 'add-to-basket']")));

           driver.findElement( By.xpath("//button[@id = 'add-to-basket']")).click();

           // check is there 2 product in basket
           // go to basket
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[3]/div/a")));
           driver.findElement( By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[3]/div/a")).click();

           // get basket info

           String totalprroduct = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[3]/div/div[1]/div/div[5]/div[1]/div/ul/li[1]/div[1]")).getText();
           System.out.println("total product:" +totalprroduct);

           Assert.assertEquals(totalprroduct, expectedproduct);

           // delete all prdocut in basket

           driver.findElement( By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[6]/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/a/i")).click();






    }
}



 
 
 
 
 
 
 





























        


  








