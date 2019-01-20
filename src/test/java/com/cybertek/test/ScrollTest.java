package com.cybertek.test;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ScrollTest extends TestBase {
    @Test
    public void test(){
        driver.get("https://youtube.com");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_UP).perform();
        actions.sendKeys(Keys.ARROW_LEFT).perform();
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        actions.sendKeys(Keys.PAGE_UP);
        actions.sendKeys(Keys.PAGE_UP);
    }
}
