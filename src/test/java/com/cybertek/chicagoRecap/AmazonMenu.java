package com.cybertek.chicagoRecap;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonMenu extends TestBase {

    @Test// moveToElemnent();
    public void amazonTitle() throws InterruptedException {
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        WebElement nav = driver.findElement(By.id("icp-nav-flyout"));
        actions.moveToElement(nav).perform();
        Thread.sleep(10000);

    }

    @Test //doubleClick();
    public void doubleClick() throws InterruptedException {
        driver.get("http://primefaces.org/showcase/ui/misc/effect.xhtml");

        WebElement fold = driver.findElement(By.id("fold_header"));
        Actions action = new Actions(driver);
        action.doubleClick(fold).perform();
        Thread.sleep(10000);

        WebElement footer = driver.findElement(By.className("footer-info-left"));
        action.moveToElement(footer).perform();
        Thread.sleep(6000);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='droptarget']"));
        //actions.dragAndDrop(source, target).perform(); // drags and drops the source to the target ball.
        //actions.clickAndHold(source).moveToElement(target).perform(); // it drags and holds the source. it doesn't drop.
        actions.clickAndHold(source).moveToElement(target).release().build().perform(); //
        Thread.sleep(3000);
    }

    @Test
    public void uploadEsen() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        String path = "/Users/user/Downloads/test.txt";
        Thread.sleep(4000);
        fileUpload.sendKeys(path);
        Thread.sleep(4000);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(10);

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='uploaded-files']")).isDisplayed());

    }


    @Test
    public void upladMarufjon(){
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String path = "/Users/user/Downloads/test.txt";
        chooseFile.sendKeys(path);
        driver.findElement(By.id("file-submit")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());
    }




}
