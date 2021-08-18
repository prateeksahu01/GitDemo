package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.ResetPassword;
import abc.Base;

public class HomePage extends Base {
	 public WebDriver driver;
	 public LoginPage lp;
	 ResetPassword rp;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
		
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {
		LandingPage l = new LandingPage(driver);
		 lp=l.getLogin(driver);
		
		lp.getEmail().sendKeys(username);
		lp.getPassWord().sendKeys(password);
		System.out.println(text);
		lp.getLogin().click();
		log.info("clicked on Login button");
	
		
	}

	@DataProvider
	public Object[][] getData() {
		
		Object[][] data=new Object[1][3];
		
		data[0][0]="abc@gmail.com";
		data[0][1]="123456";
		data[0][2]="Restricted user";
		
//		data[1][0]="abc2@gmail.com";
//		data[1][1]="234567";
//		data[1][2]="Non Restricted user";
//		
		return data;
	}
	
	@Test
	public void resetPassword() {
		rp=lp.clickForgotPassword(driver);
		rp.enterEmail("abc@gmail.com");
		rp.clickSendMeInstruction();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
