package com.cybertek.test;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest extends TestBase {

    //@Test
    public void printWholeTable() {

        //Calling a method => login(){}
        login();

        //printing the whole table content:
        WebElement tableContent = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(tableContent.getText());

    }

    //Defining a method => loging(){}
    public void login() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Default.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);

    }

    //if we want to get a tidy content of the table we need to do the following steps:
    @Test
    public void printAllHeaders() {
        login();
        List<WebElement> headers =
                driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }

    /*
    prints the number of rows
    prints all rows ==
    prints
     */
    @Test
    public void printAllRows() {
        login();

        List<WebElement> allrows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        System.out.println("Number of rows: " + allrows.size());

        for (WebElement header : allrows) {
            System.out.println(header.getText());
        }

        System.out.println("Printing row: " + 3);
        System.out.println(allrows.get(2).getText());
    }

    @Test
    public void printTableSize() {
        login();

        List<WebElement> allrows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        System.out.println("Number of all rows: " + allrows.size());

        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[1]/th"));
        System.out.println("Number of all cols: " + allHeaders.size());
    }



    @Test
    public void printRow2(){
        login();
        WebElement row5 = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[5]"));
            System.out.println(row5.getText());
        }



    @Test
    public void printRowContent(){
        login();
        List<WebElement> cells = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td"));
        for(WebElement header : cells) {
            System.out.println(header.getText());
        }
    }


    @Test
    public void printACell(){
        login();
        WebElement cell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td[11]"));
        System.out.println(cell.getText());

        System.out.println(getCell(6, 11));
    }


    public WebElement getCell(int row, int col){
        String xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+row+"]/td["+col+"]";
        return driver.findElement(By.xpath(xpath));
    }

//    public static void findByText_SmartBear(WebDriver driver, String name){
//        String xpath = "//td[.='"+name+"']/../td[5]";
//        WebElement nameDate = driver.findElement(By.xpath(xpath));
//        System.out.println(nameDate.getText());
//    }

    @Test
    public void printColumnContent(){
        login();
        List<WebElement> columnContent = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));

        for(WebElement header : columnContent){
            System.out.println(header.getText());
        }
    }


    @Test
    public void selectCheckBox(){
        login();
        WebElement checkBox = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]/input"));
        System.out.println(checkBox.isSelected());
        checkBox.click();
        System.out.println(checkBox.isSelected());
    }


    @Test
    public void test(){
        login();
        int nameIndex = getColumnIndex("Name");
        System.out.println(nameIndex);

        boolean found = false;

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+nameIndex+"]"));
        for(int i = 0; i < allNames.size(); i++){
            if(allNames.get(i).getText().equals("Mark Smith")){
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);


        int cityIndex = getColumnIndex("City");
        List<WebElement> allCities = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+cityIndex+"]"));

        for(int i = 0; i < allCities.size(); i++){
            if(allCities.get(i).getText().equals("Whitestone, British")){
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }

//get a column name as a parameters. Returns the index of the column name.
    public int getColumnIndex(String column){
        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[1]/th"));
        for(int i = 0; i < allHeaders.size(); i++){
            if(allHeaders.get(i).getText().equals(column)){
                return i+1;
            }
        }
        return 0;
    }






}







