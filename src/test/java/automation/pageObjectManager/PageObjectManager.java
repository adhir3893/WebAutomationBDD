package automation.pageObjectManager;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import auotmation.pageObjects.AccountsPage;
import auotmation.pageObjects.GeoDistributionPage;
import auotmation.pageObjects.HomePage;
import auotmation.pageObjects.LobbyPage;
import automation.testDataManager.FileReaderManager;

public class PageObjectManager {

	private WebDriver driver;
	private HomePage homePage;
	private LobbyPage lobbyPage;
	private AccountsPage accountsPage;
	private GeoDistributionPage geoDistributionPage;

	public PageObjectManager(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public LobbyPage getLobbyPage() {
		return (lobbyPage == null) ? lobbyPage = new LobbyPage(driver) : lobbyPage;
	}	
	
	public AccountsPage getAccountsPage() {
		return (accountsPage == null)? accountsPage = new AccountsPage(driver) : accountsPage;
	}
	

	public GeoDistributionPage getGeoDistributionPage() {
		return (geoDistributionPage == null)? geoDistributionPage = new GeoDistributionPage(driver) : geoDistributionPage;
	}
	

}
