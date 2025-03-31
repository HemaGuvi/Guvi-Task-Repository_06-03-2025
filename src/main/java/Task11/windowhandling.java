package Task11;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowhandling {

	public static void main(String[] args) {
		myWindowHandling("https://the-internet.herokuapp.com/windows");
	}
	public static void myWindowHandling(String Url)
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get(Url);
	driver.manage().window().maximize();
	String parentwindow = driver.getWindowHandle();
	driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
	Set<String> allwindows = driver.getWindowHandles();
	for(String window:allwindows)
	{
		if(!window.equals(parentwindow))
		{
			driver.switchTo().window(window);
			String pageContent = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
			if(pageContent.equals("New Window"))
			{
				System.out.println("Text in the child window::"+pageContent);
			}
			driver.close();
		}
	}
	driver.switchTo().window(parentwindow);
	if(parentwindow.equals(driver.getWindowHandle()))
	{
		System.out.println("Parent window is Active");
	}
	else {
		System.out.println("Error occured!!!");
	}
	driver.quit();
}
}
