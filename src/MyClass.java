import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyClass {

    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod
    public void myBeforeMethod() {
        // Set the WebDriver executable path (Replace with the actual path to chromedriver.exe)
        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        // Initialize the WebDriver instance
        driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://global.almosafer.com/ar");

        // Initialize SoftAssert for assertions
        softAssert = new SoftAssert();
    }

    @Test
    public void testAlmosaferWebsite() {
        // Find and click the button with the class name "sc-jTzLTM"
        WebElement theButton = driver.findElement(By.className("sc-jTzLTM"));
        theButton.click();

        // 1. Check the language
        WebElement languageElement = driver.findElement(By.cssSelector("[data-testid='Header__LanguageSwitch']"));
        String language = languageElement.getText();
        softAssert.assertEquals(language, "English", "Language is not as expected.");

        // 2. Check the currency
        WebElement currencyElement = driver.findElement(By.cssSelector("[data-testid='Header__CurrencySelector']"));
        String currency = currencyElement.getText();
        softAssert.assertEquals(currency, "SAR", "Currency is not as expected.");

        // 3. Check the hotel tab is selected
        WebElement hotelTab = driver.findElement(By.xpath("//a[contains(@class, 'active') and contains(@href, '/hotels')]"));
        softAssert.assertTrue(hotelTab.isDisplayed(), "Hotel tab is not selected.");

        // Perform additional test steps as needed

        // Use softAssert.assertAll() to report all assertion failures
        softAssert.assertAll();
    }

    @AfterMethod
    public void myAfterMethod() {
        // Close the WebDriver instance after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
