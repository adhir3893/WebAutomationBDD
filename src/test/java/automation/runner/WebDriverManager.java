package automation.runner;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import automation.testDataManager.FileReaderManager;

public class WebDriverManager {

	private WebDriver driver;

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		String browser = null;
		String driverPath;

		try {
			browser = FileReaderManager.getInstance().getConfigReader().getTestData().get("browser");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if (browser.equalsIgnoreCase("chrome")) {
			if (System.getProperty("os.name").toLowerCase().contains("window")) {
				driverPath = System.getProperty("user.dir") + File.separator + "bin//chromedriver.exe";
			} else {
				driverPath = System.getProperty("user.dir") + File.separator + "bin//chromedriver";
			}
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {

		} else if (browser.equalsIgnoreCase("firefox")) {

		} else if (browser.equalsIgnoreCase("safari")) {

		}

		return driver;

	}

	public void closeDriver() {
		driver.close();
		// driver.quit();
	}
}
