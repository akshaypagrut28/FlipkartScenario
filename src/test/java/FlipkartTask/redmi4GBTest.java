package FlipkartTask;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class redmi4GBTest 
{
	
	@Test
	public void redmiTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.name("q")).sendKeys("redmi");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> allphones = driver.findElements(By.xpath("//li[contains(text(),'4 GB RAM ')]/../../.."));
		
		for(WebElement redmiphone : allphones)
		{
		
			System.out.println(redmiphone.getText());
		}
		driver.close();
		
	}

}
