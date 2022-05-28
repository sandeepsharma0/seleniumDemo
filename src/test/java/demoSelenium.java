import org.openqa.selenium.By;

import java.io.IOException;

public class demoSelenium extends initBrowser{


    public static void main(String[] args) throws IOException, InterruptedException {
        initBrowser.openAut();
        initBrowser.enterText(By.xpath("//input[@type='search']"),"Shoes");
        Thread.sleep(2000);
        initBrowser.mouseAction(By.xpath("//button[@class='search-clear']"));
        initBrowser.waitUntilVisible(By.className("ltklpopup-bg-c"));
        initBrowser.enterText(By.name("ltkpopup-email"),"sandeep");
        initBrowser.mouseAction(By.id("ltkpopup-submit"));
        //initBrowser.waitUntilVisible(By.xpath("(//div[@id='ltkpopup-contents'])[1]"));
        //initBrowser.verify(By.xpath("(//div[@id='ltkpopup-contents'])[1]"));
        initBrowser.waitUntilVisible(By.xpath("//div[@role='text']"));
        initBrowser.verify(By.xpath("//div[@role='text']"));
        initBrowser.waitUntilClickable(By.xpath("//button[@class='ltkpopup-close']"));
        initBrowser.mouseAction(By.xpath("//button[@class='ltkpopup-close']"));
        driver.close();




    }


}
