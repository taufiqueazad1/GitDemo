package selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Practice_1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("au");
		Thread.sleep(3000);
		
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item'] /div"));
		//System.out.println(options);
		
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("Macau"))
			{
				option.click();
				break;
			}
			
			
		}
		
		WebElement staticdropdown=driver.findElement(By.id("dropdown-class-example"));
		Select dropdown=new Select(staticdropdown);
		dropdown.selectByIndex(2);
		

		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		driver.findElement(By.name("enter-name")).sendKeys("Taufique");
		driver.findElement(By.id("alertbtn")).click();
		Alert a=driver.switchTo().alert();
		Thread.sleep(2000);
		a.accept();
		driver.findElement(By.name("enter-name")).sendKeys("Azad");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		a.accept();
		
		driver.findElement(By.xpath("//button[@class='btn-style class1']")).click();
		Set<String> windows =driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentid=it.next();
		String childid=it.next();
		driver.switchTo().window(parentid);
		
		SoftAssert a1=new SoftAssert();
		
		int linksize = driver.findElements(By.tagName("a")).size();
		System.out.println("Total Link Available="+linksize);
		
		WebElement footerlink = driver.findElement(By.xpath("//div[@class=' footer_top_agile_w3ls gffoot footer_style']"));
		
		int footerLinkSize = footerlink.findElements(By.tagName("a")).size();
		System.out.println("Footer Link Size="+footerLinkSize);
		
		List<WebElement> counts = driver.findElements(By.xpath("//div[@class='tableFixHead']//tr//td[4]"));
		int sum=0;
		for(int i=0;i<counts.size();i++)
		{
			sum=sum+Integer.parseInt(counts.get(i).getText());
		}
		
		System.out.println("Sum= "+sum);
		
		
		String text=driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
        System.out.println(text);
		int totalSum=Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, totalSum);
		
		
		
	}

}
