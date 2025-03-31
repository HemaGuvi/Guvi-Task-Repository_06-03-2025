package Task11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class framehandling {
public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		topframe();
		bottomframe();
	}
	public static void topframe() throws InterruptedException
	{
		driver.switchTo().frame("frame-top");
		int numberofframesintopframe = driver.findElements(By.tagName("frame")).size();
		System.out.println("Number of frames in the top-frame::"+numberofframesintopframe);
		Thread.sleep(2000);
//		WebElement leftframe = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
		driver.switchTo().frame("frame-left");
		String leftframetext=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
		System.out.println("Left frame has the text::"+leftframetext);
		//driver.switchTo().frame("frame-top");
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-middle");
		WebElement middleframe=driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
		System.out.println("Middle frame has the text::"+middleframe.getText());
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-right");
		WebElement rightframe=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
		System.out.println("Rigth frame has the text::"+rightframe.getText());
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
	}
	public static void bottomframe()
	{
		
		driver.switchTo().frame("frame-bottom");
		WebElement bottomframe = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
		System.out.println("Bottom frame has the text::"+bottomframe.getText());
		driver.switchTo().parentFrame();
		System.out.println("Current page URL::"+driver.getCurrentUrl());
	}
}
