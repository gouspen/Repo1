package gous;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	private static WebDriver driver;
	private static String userName, passWord;
	private static String file = "F:\\codingRound-master\\codingRound-master\\src\\main\\java\\gous\\data.properties";

	public BaseClass(WebDriver driver) {
		this.driver = driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String getUserName() {
		return userName;
	}

	public static String getPassword() {
		return passWord;
	}

	public static void wait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void openBrowser() throws Exception {

		FileReader reader = new FileReader(file);

		Properties property = new Properties();

		property.load(reader);

		System.setProperty("webdiver.gecko.driver", "F:\\codingRound-master\\codingRound-master\\geckodriver.exe");
//		System.setProperty("webdiver.chrome.driver", "F:\\codingRound-master\\codingRound-master\\chromedriver.exe");
//		 Create object of ChromeOptions class
//		ChromeOptions options = new ChromeOptions();

		// add parameter which will disable the extension
//		options.addArguments("--disable-extensions");
//		driver = new ChromeDriver(options);
//		driver.get(property.getProperty("url"));
		driver = new FirefoxDriver();
		driver.get("https://www.cleartrip.com");
		driver.manage().window().maximize();
	}

	public static void readPropertiesFile() throws Exception {
		FileReader reader = new FileReader(file);

		Properties property = new Properties();

		property.load(reader);

		userName = property.getProperty("username");
		passWord = property.getProperty("password");
	}

	public static void closBrowser() throws Exception {
		Thread.sleep(5000L);
		driver.close();
	}

}
