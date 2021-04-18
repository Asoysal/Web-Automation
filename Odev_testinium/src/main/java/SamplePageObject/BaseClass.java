package SamplePageObject;

import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BaseClass {

    WebDriver driver;
    String actualUrl_login = "https://www.gittigidiyor.com/";
    String actualUrl_second = "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2";
    String expectedproduct = "Ürün Toplamı (2 Adet)";
    @Before
    public void StartBrowser(){

        //Tarayacı baslatma
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Alper\\Desktop\\webdriver\\geckodriver.exe");

        driver = new FirefoxDriver();
        System.out.println("Driver Sürücüsü Fireox'da oluşturuldu");
        driver.manage().window().maximize();

    }

    @After
    public void CloseBrowser(){
        //Close driver
        driver.quit();
        System.out.println("Browser Kapatıldı.");

    }
}
