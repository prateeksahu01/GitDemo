package abc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop=new Properties();
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\abc\\Data.properties");
	    prop.load(fis);
	    
	    String browserName=System.getProperty("browser");
	    //String browserName=prop.getProperty("browser");
	    
	    if(browserName.equals("chrome")) {
	    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\abc\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("headless");
	    	driver=new ChromeDriver();
	    }
	    
	 
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	    
	  return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts=	(TakesScreenshot) driver;
		File sources=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(sources, new File(destinationFile));
		return destinationFile;
	}

}
