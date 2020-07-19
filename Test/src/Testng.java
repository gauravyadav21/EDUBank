import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Testng {
	 WebDriver driver;
	 ExtentReports reports;
	 ExtentTest test;

	@Test
    public void test()throws Exception {
       
        
    driver.get("https://testng.org/doc/download.html");
    test.log(LogStatus.INFO, "userName given is Steven");
    
	test.log(LogStatus.INFO, "user password is entered");	
	
	test.log(LogStatus.INFO, "user clicked on submit button");
	test.log(LogStatus.PASS, "Login is success"); 
	test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+ "test failed"); 
	}
	
	@BeforeClass
	public void beforetest()throws Exception {
		
	        reports = new ExtentReports("user.dir"+"\\extentreports.html");
	    	test = reports.startTest("ExtentDemo");

	        System.setProperty("webdriver.chrome.driver","C:\\Users\\Gaurav\\Desktop\\chromedriver.exe");
	        driver = new ChromeDriver();
	}
	@AfterClass
	public void aftertest()throws Exception {
		reports.endTest(test);
		reports.flush();
		driver.quit();
 
    }
	
public String capture(WebDriver driver) throws Exception {
	
	
	TakesScreenshot ts= (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\Gaurav\\Desktop"+System.currentTimeMillis()+".png");
		String errflpath = destFile.getAbsolutePath();
		FileUtils.copyFile(srcFile, destFile);
		return errflpath;
		
	}
}

