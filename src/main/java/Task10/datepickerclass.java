package Task10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datepickerclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		datepicker(driver,"10","June", "2026");
	}
public static void datepicker(WebDriver driver,String date, String month, String year)
	{
	while(true)
	{
		String currentMonth= driver.findElement(By.className("ui-datepicker-month")).getText();
		String currentYear=driver.findElement(By.className("ui-datepicker-year")).getText();
		if(currentMonth.equals(month) && currentYear.equals(year))
		{
			break;
		}
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	}
	    driver.findElement(By.xpath("//a[text()='"+date+"']")).click();
	}
}


