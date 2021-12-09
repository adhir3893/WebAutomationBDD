package automation.helper;

import java.io.IOException;
import java.util.Map;

import automation.genericLibrary.GenericMethodsManager;
import automation.pageObjectManager.PageObjectManager;
import automation.runner.WebDriverManager;
import automation.testDataManager.FileReaderManager;

public class TestContext {

	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	private GenericMethodsManager genericMethodsManager;
	private Map<String, String> testData;

	public TestContext() throws IOException {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		genericMethodsManager = new GenericMethodsManager(webDriverManager.getDriver());
		testData = FileReaderManager.getInstance().getConfigReader().getTestData();

	}

	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public GenericMethodsManager getGenericMethodsManager() {
		return genericMethodsManager;
	}

	public Map<String, String> getTestData() {
		return testData;
	}

}
