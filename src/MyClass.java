import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyClass {

    SoftAssert myAssert = new  SoftAssert();
    WebDriver driver = new ChromeDriver();
    String expectedMobileNumber = "+966554400000" ;
    String expectedCurrency = "SAR" ;
    String expectedLanguage = "English" ;
    String expectedClickedButton = "طيران" ;

    @BeforeMethod
    public void myBeforeMethod() {
    	
    }

    @Test
    public void testAlmosaferWebsite() {
    	// To Enter Almosafer Website
    	driver.get("https://www.almosafer.com/ar?ncr=1");
    	
    	// Check the Mobile Number
    	String  actualMobileNumber = driver.findElement(By.className("sc-hUfwpO")).getText();
    	myAssert.assertEquals(actualMobileNumber, expectedMobileNumber , "This is To Check The Mobile Number");

        // Check the Language
    	String actualLanguage = driver.findElement(By.className("sc-gkFcWv")).getText();
        myAssert.assertEquals(expectedLanguage, actualLanguage , "This is To Check The Language");
        
        
        // Check the Currency
    	String actualCurrency = driver.findElement(By.className("sc-dRFtgE")).getText();
        myAssert.assertEquals(expectedCurrency, actualCurrency , "This is To Check The Currancy");
        
        
        // Check the FlightTab
        String actualClickedButton = driver.findElement(By.xpath("//*[@aria-selected='true']")).getText();
        myAssert.assertEquals(expectedClickedButton, actualClickedButton , "This is To Check The Clicked Button");
        

        myAssert.assertAll();
    }

    @AfterMethod
    public void myAfterMethod() {
    	
    }
}
