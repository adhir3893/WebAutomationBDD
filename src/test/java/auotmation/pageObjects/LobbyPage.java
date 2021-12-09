package auotmation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LobbyPage {

	public LobbyPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='wheel-legend-container']//span[contains(text(),'STAGE 3')]")
	public WebElement stage3Link;

	@FindBy(how = How.XPATH, using = "//*[@id='globalWheelTab']")
	public WebElement lobbyTabBar;

}
