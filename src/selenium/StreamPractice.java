package selenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//tr//th[1]")).click();
		
		List<WebElement> ElementList=driver.findElements(By.xpath("//tr//td[1]"));
		
		List<String> StreamList=ElementList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> SortedList=StreamList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(StreamList.equals(SortedList));
		
		System.out.println("=================");
		
		//get price of beans
		List<String> Price;//to make global 
		do {
			List<WebElement> totalElement=driver.findElements(By.xpath("//tr//td[1]"));
		Price=totalElement.stream().filter(s->s.getText().contains("Rice")).map(s->GetPriceVeggies(s))
		.collect(Collectors.toList());
		Price.forEach(a->System.out.println(a));
		if(Price.size()<1)
		{
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}

		}while(Price.size()<1);
	}

	private static String GetPriceVeggies(WebElement s) {
		// TODO Auto-generated method stub
		
	    String PriceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return PriceValue;
	}

}
