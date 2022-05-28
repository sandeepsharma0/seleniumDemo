import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class initBrowser {
    static WebDriver driver = null;
    public static void openAut() throws IOException {


        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream("C:\\Users\\E008631\\IdeaDemoProjects\\seleniumDemo\\src\\test\\java\\config.properties");
       prop.load(fis);
       String browserName=prop.getProperty("browser");

       if(browserName.equalsIgnoreCase("chrome")){
           try {
               System.setProperty("webdriver.chrome.driver","C:\\Users\\E008631\\Desktop\\Drivers\\browserDrivers\\chromedriver.exe");
                driver=new ChromeDriver();
           }catch(Exception e){
               System.out.println(e);
           }
       } else if (browserName.equalsIgnoreCase("Edge")) {
           try {
               System.setProperty("webdriver.edge.driver","C:\\Users\\E008631\\Desktop\\Drivers\\browserDrivers\\msedgedriver.exe");
                driver=new EdgeDriver();
           }catch(Exception e){
               System.out.println(e);
           }
       } else if (browserName.equalsIgnoreCase("FireFox")) {
           try {
               System.setProperty("webdriver.gecko.driver", "C:\\Users\\E008631\\Desktop\\Drivers\\browserDrivers\\geckodriver.exe");
                driver = new FirefoxDriver();
           } catch (Exception e) {
               System.out.println(e);
           }
       }
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.get(prop.getProperty("url"));




    }
    public static void enterText(By loc, String data){
        try{
            driver.findElement(loc).sendKeys(data);

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void clickEle(By loc){
        try{
            driver.findElement(loc);

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void mouseAction(By loc){
        try {
            Actions actions = new Actions(driver);
            WebElement target = driver.findElement(loc);
            actions.moveToElement(target).click().build().perform();
        }catch (Exception e){
            System.out.println(e);

        }
    }
    public static void waitUntilVisible(By loc) {
        try {
            WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(30));
            wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void waitUntilClickable(By loc) {
        try {
            WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(20));
            wt.until(ExpectedConditions.elementToBeClickable(loc));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void verify(By loc){
        try {

            String str=driver.findElement(loc).getText();
            System.out.println(str);

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
