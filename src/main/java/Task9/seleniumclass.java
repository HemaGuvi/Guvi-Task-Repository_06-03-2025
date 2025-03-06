package Task9;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumclass {
static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myFirefoxBrowserSetup("https://www.google.com");
		myGoogleBrowserSetup("https://www.demoblaze.com");
		myThirdTask("https://www.wikkipedia.com");
	}
	public static void myFirefoxBrowserSetup(String url) {
	WebDriverManager.firefoxdriver().setup();
	//driver=new FirefoxDriver();
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get(url);
	String CurrentURL = driver.getCurrentUrl();
	System.out.println("Current URL:::"+CurrentURL);
	driver.navigate().refresh();
	driver.quit();
	}
	public static void myGoogleBrowserSetup(String link) 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(link);
		driver.manage().window().maximize();
		String title=driver.getTitle();
		if(title.equals(title))
		{
			System.out.println("Page landed on correct Website");
		}
		else
		{
			System.out.println("Page not landed on correct website");
		}
		
	}
	static void myThirdTask(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Artifical Integlligence");
		driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']")).click();
		driver.findElement(By.xpath("//a[@title='History of artificial intelligence']")).click();
		System.out.println("Title of the page::"+driver.findElement(By.xpath("//span[text()='History of artificial intelligence']")).getText());
		
	}
}
