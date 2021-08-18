package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import abc.Base;

public class ValidateTitle extends Base {
    public WebDriver driver;
	LandingPage l;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to HomePage");
		 l = new LandingPage(driver);
	}

	@Test
	public void validateTitle() throws IOException {
		  

		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("successfully validated Title");
		Assert.assertTrue(l.getBar().isDisplayed());
		log.info("successfully displayed navigation bar");
	}

	@Test
	public void validateHeader() throws IOException {
		Assert.assertTrue(l.getHeader().isDisplayed());
		log.info("successfully displayed the header");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
