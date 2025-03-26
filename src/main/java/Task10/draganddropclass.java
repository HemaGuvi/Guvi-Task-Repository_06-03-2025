package Task10;

import java.lang.annotation.Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class draganddropclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		myDragAndDrop();
	}
	public static void myDragAndDrop()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
		String Targettest = driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]")).getText();
		String variablenametarget= target.getCssValue("background");
		System.out.println(variablenametarget);
		if(Targettest.equals("Dropped!") )
		{
			System.out.println("Successfully Drag and dropped!!");
		}
		else
		{
				System.out.println("Error");
		}
	}}
