package auotmation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "username")
	public WebElement usernameTextField;

	@FindBy(how = How.ID, using = "password")
	public WebElement passwordTextField;

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	public WebElement loginButton;
	
	@FindBy(how = How.ID, using = "pills-tab")
	public WebElement topNavigationLinks;
	
	@FindBy(how = How.ID, using="pills-accounts-tab")
	public WebElement accountLink;
	
	@FindBy(how =How.ID, using ="pills-hcp-tab"	)
	public WebElement geoDistributionLink;

	

}
