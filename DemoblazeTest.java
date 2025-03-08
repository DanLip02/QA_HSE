import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoblazeTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setup() {
        // Автоматически загружает и настраивает ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Инициализация драйвера и настройка окна браузера
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/#");

        // Инициализация объекта страницы
        homePage = new HomePage(driver);
    }

    @Test
    public void testNavigationToProduct() {
        // Переход к продукту "Samsung galaxy s6"
        homePage.clickOnProduct("Samsung galaxy s6");
        // Здесь можно добавить дополнительные проверки, например, сравнение заголовка страницы
    }

    @AfterClass
    public void teardown() {
        // Завершение работы драйвера
        if (driver != null) {
            driver.quit();
        }
    }
}
