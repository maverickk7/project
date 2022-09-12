import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Screen {
	public static WebDriver driver;
	@Test
	public void capture() throws InterruptedException {
		System.setProperty("webdriver.opera.driver", "D:\\operadriver.exe");
		WebDriver driver=new OperaDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.id("emailk")).sendKeys("aaaa@gmail.com");
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	@AfterMethod 
	public void takeScreenShotOnFailure(ITestResult result) throws IOException { 
		if (ITestResult.FAILURE==result.getStatus()) { 
			try 
			{
			// Create refernce of TakesScreenshot
			TakesScreenshot ts=(TakesScreenshot)driver;

			// Call method to capture screenshot
			File source=ts.getScreenshotAs(OutputType.FILE);

			// Copy method  specific location here it will save all screenshot in our project home directory and
			// result.getName() will return name of test case so that screenshot name will be same
			try{
			FileHandler.copy(source, new File("C:\\Users\\DELL\\Desktop\\selenium\\screenshots\\test.png"));
			System.out.println("Screenshot taken");
			
			} 
			catch (Exception e)
			{
			System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
			
		} finally {
			System.out.println();
		}
	}}
}

