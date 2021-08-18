package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPassword {

	@FindBy(id="user_email")
	private WebElement email;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement sendMeInstruction;
	
	
	
	public ResetPassword(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String username) {
		email.sendKeys(username);
	}
	
	public void clickSendMeInstruction() {
		sendMeInstruction.click();
	}
	

}
