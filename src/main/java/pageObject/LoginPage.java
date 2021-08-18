package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abc.Base;

public class LoginPage extends Base {
	
	@FindBy(id="user_email")
	private WebElement email;
	
	@FindBy(id="user_password")
	private WebElement password;
	
	@FindBy(css="[value='Log In']")
	private WebElement login;
	
	@FindBy(css=".link-below-button")
	private WebElement forgotPassword;
	
	
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public WebElement getEmail() {
		return email;
		
	}

	public WebElement getPassWord() {
		return password;
		
	}
	
	public WebElement getLogin() {
		return login;
		
	}
	
	public ResetPassword clickForgotPassword(WebDriver driver) {
		forgotPassword.click();
		return new ResetPassword(driver);
		
	}
		
}
