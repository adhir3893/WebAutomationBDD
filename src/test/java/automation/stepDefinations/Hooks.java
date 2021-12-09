package automation.stepDefinations;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import automation.helper.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hooks {

	TestContext testContext;
	private WebDriver driver;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before(order = 1)
	public void BeforeSteps() {
		System.out.println("before steps");
		driver = testContext.getWebDriverManager().getDriver();
		driver.get(testContext.getTestData().get("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@After(order = 0)
	public void AfterSteps() {
		// testContext.getWebDriverManager().quitDriver();
		System.out.println("after steps");
		testContext.getWebDriverManager().closeDriver();
	}

	@Before(order = 0)
	public void beforeScenario(Scenario scenario) {
		System.out.println("before scenario");
		Reporter.assignAuthor(System.getProperty("user.name"));
	}

	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		System.out.println("after scenario");
		String newDate = new SimpleDateFormat("ddMMyyyyhhmmss").format(new Date());
		String dateofScreenshot = newDate.substring(0, 8);
		String timeOfScreenshot = newDate.substring(8, 14);
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		try {
			File dir = new File(System.getProperty("user.dir") + "/screenshots" + File.separator + newDate);
			if (!dir.exists())
				dir.mkdir();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			// This takes a screenshot from the driver at save it to the specified location
			File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver())
					.getScreenshotAs(OutputType.FILE);

			// Building up the destination path for the screenshot to save
			// Also make sure to create a folder 'screenshots' with in the cucumber-report
			// folder
			File destinationPath = new File(System.getProperty("user.dir") + "/screenshots/" + newDate + "/"
					+ screenshotName + dateofScreenshot + "_" + timeOfScreenshot + ".png");

			// Copy taken screenshot from source location to destination location
			Files.copy(sourcePath, destinationPath);

			// This attach the specified screenshot to the test
			Reporter.addScreenCaptureFromPath(destinationPath.toString());
			System.out.println("Screenshot saved: " + destinationPath.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
