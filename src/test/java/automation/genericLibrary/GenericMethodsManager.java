package automation.genericLibrary;

import org.openqa.selenium.WebDriver;

public class GenericMethodsManager {

	WebDriver driver;
	GenericMethods genericMethods;

	public GenericMethodsManager(WebDriver driver) {
		this.driver = driver;
	}

	public GenericMethods getGenericMethods() {
		return (genericMethods == null) ? genericMethods = new GenericMethods(driver) : genericMethods;
	}

}
