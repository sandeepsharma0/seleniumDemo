import javafx.beans.property.SetProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class demoSelenium extends initBrowser{


    public static void main(String[] args) throws IOException {
        initBrowser.openAut();
        initBrowser.enterText(By.xpath("//input[@type='search']"),"Shoes");
        initBrowser.clickEle(By.xpath("(//button[@type='button'])[2]"));


    }


}
