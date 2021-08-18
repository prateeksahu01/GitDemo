package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abc.Base;

public class LandingPage extends Base {
	
	@FindBy(css="a[href*=sign_in")
	private WebElement login;
	
	@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	private WebElement title;
	
	@FindBy(css=".nav.navbar-nav.navbar-right")
	private WebElement bar;
	
	@FindBy(css="div[class*=video-banner] h3")
	private WebElement header;
	
	public LandingPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public LoginPage getLogin(WebDriver driver) {
		 login.click();
		 return new LoginPage(driver);
		
	}

	public WebElement getTitle() {
		return title;
		
	}
		
	public WebElement getBar() {
		return bar;
	}
	
	public WebElement getHeader() {
		return header;
	}
}
