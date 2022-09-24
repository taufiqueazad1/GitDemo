package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//input[@value='radio1']")).click();

		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());

		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());

		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(), 3);

		driver.quit();

	}

}
