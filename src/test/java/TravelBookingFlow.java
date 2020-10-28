import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelBookingFlow {
    public WebDriver driver;

    @Before
    public void startBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thoughtpooladmin\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void bookTicketsFlow(){
        //1. Go to travel url
        driver.get("https://www.busonlineticket.com/booking/bus-tickets.aspx");

        //2. Select source as Cameron Highlands and destination as Kuala Lumpur
        WebElement sourceLocation = driver.findElement(By.xpath("//input[@id='txtOriginGeneral']"));
        sourceLocation.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Cameron Highlands']")));
        sourceLocation.findElement(By.xpath("//div[text()='Cameron Highlands']")).click();

        WebElement destinationLocation = driver.findElement(By.xpath("//input[@id='txtDestinationGeneral']"));
        destinationLocation.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Kuala Lumpur']")));
        destinationLocation.findElement(By.xpath("//div[text()='Kuala Lumpur']")).click();

        //3. Select date as 20th of next immediate month
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e' and text()='Next']")));
        WebElement immediateNextMonth = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e' and text()='Next']"));
        immediateNextMonth.click();
        WebElement dateSelection = driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='20']"));
        dateSelection.click();

        //Search for a bus
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='btnBusSearchNewGeneral']"));
        searchButton.click();

        //Select the bus with least adult cost (Note: Do not sort the column in the UI)

        //Select max of 6 seats or all seats if less than 6 in the layout.

        //Click on Proceed

        //Enter Personal Details

        //DO not select any payment method.

        //Click on proceed to payment and Assert for the alert pop up and print the alert message.

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
