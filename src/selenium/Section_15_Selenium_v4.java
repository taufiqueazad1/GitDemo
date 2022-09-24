package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.File;
import java.io.IOException;


public class Section_15_Selenium_v4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//WebElement nameEditBox=driver.findElement(By.xpath("//input[@name='name']"));
		//System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		//driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
	//Screenshot of Element 	
	WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
	name.sendKeys("Taufique Azad");
	File src=name.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("ss.png"));
	
	//Height & Width
	 System.out.println(name.getRect().getDimension().getHeight());
	 System.out.println(name.getRect().getDimension().getWidth());
	 
	
	

	}

	private static Object with(By tagName) {
		// TODO Auto-generated method stub
		return null;
	}

}
