package Task10;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.hc.core5.util.Asserts;
import org.jspecify.annotations.Nullable;

import io.github.bonigarcia.wdm.WebDriverManager;

public class guviloginclass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		signup();
		Login();
	}
		public static void signup() throws InterruptedException
		{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.guvi.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("AAA");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aravindhakumar@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abcdef1");
		driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("9845050938");
		driver.findElement(By.xpath("//a[@id='signup-btn']")).click();
		Thread.sleep(4000);
		String actualpage=driver.getTitle();
		if(actualpage.equals("Signup"))
		{
			System.out.println("User account created successfully!!!");
		}
		else
		{
			System.out.println("User account not created successfullly ");
		}
		System.out.println("User registered Successfully!!!");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='profileDrpDwn']"));
		Select select=new Select(dropdown);
		select.selectByValue("Working professional in IT");
		WebElement degreedropdown=driver.findElement(By.xpath("//select[@id='degreeDrpDwn']"));
		Select selectdegreedropdown=new Select(degreedropdown);
		selectdegreedropdown.selectByVisibleText("B.E. / B.Tech. EEE");
		driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2015");
		driver.findElement(By.xpath("//a[@class='btn details-btn']")).click();
		}
		public static void Login() throws InterruptedException	{
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.guvi.in/");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//a[@id='login-btn']")).click();
			JavascriptExecutor JS=(JavascriptExecutor) driver;
			JS.executeScript("window.scrollBy(0,250)","");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aravindhakumar@gmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abcdef1");
			driver.findElement(By.xpath("//a[@class='login-btn']")).click();
			Thread.sleep(2000);
			String actualpage=driver.getTitle();
			if(actualpage.equals("https://www.guvi.in/courses/?current_tab=myCourses"))
			{
				System.out.println("User Successfully logged in!!!");
				
			}
			else
			{
				System.out.println("Something went wrong!!!");
				
			}
			driver.quit();
		}
}

