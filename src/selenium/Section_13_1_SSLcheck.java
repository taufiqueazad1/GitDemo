package selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Section_13_1_SSLcheck {

	public static void main(String[] args) throws IOException {
		
		ChromeOptions options= new ChromeOptions();
		//FirefoxOptions option=new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		
		//SET Proxy
		/*Proxy proxy=new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);*/
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("D:\\seleniumSS\\ss6.png"));
		
		
		driver.quit();

	}

}
