package selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day1 {
	public static void main(String[] args) {
		/*System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
	
		driver.get("https://rahulshettyacademy.com/");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());*/
		
		for(int i=2;i<=100;i++)
        {
            if(i%2==0){
                System.out.println(i);
             }
        }
		//driver.quit();
	}

}
 