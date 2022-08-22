import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Pom1 {
	@Parameters("browser")
	@Test
	public void testfb() throws InterruptedException {
		System.setProperty("webdriver.opera.driver", "D:\\operadriver.exe");
		WebDriver driver=new OperaDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com");
	//driver.findElement(By.xpath("//a[text()='Forgotten password?']"));
Thread.sleep(3000);
	driver.quit();
	}
}
