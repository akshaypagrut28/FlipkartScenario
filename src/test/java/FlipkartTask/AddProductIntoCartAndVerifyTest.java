package FlipkartTask;



import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductIntoCartAndVerifyTest 
{
	
	@Test
	public void addToCartAndVerify()
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.name("q")).sendKeys("winter heater");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement product = driver.findElement(By.xpath("//a[contains(text(),'DARSHANAM WORLD')]"));
		String exepectedtext = product.getText();
		System.out.println(exepectedtext);
		product.click();
		Set<String> allwindowids = driver.getWindowHandles();
		
		for(String widids : allwindowids)
		{
			driver.switchTo().window(widids);
		}
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		String actualtext = driver.findElement(By.xpath("//a[contains(text(),'DARSHANAM WORLD 220v 500w')]")).getText();
		System.out.println(actualtext);
		Assert.assertEquals(actualtext.contains(exepectedtext), true);
		driver.close();
	}

}
