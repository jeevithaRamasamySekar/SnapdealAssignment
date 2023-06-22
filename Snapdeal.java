package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement menfashion = driver.findElement(By.xpath("(//span[contains(.,Men) and @class='catText'])[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(menfashion).click().perform();
		WebElement sports=driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]"));
		act.click(sports).perform();
		WebElement sportscount=driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following-sibling::div"));
		System.out.println("sports shoes count "+sportscount.getText());
		WebElement trainingshoe=driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		act.click(trainingshoe).perform();
		WebElement popularity=driver.findElement(By.xpath("//span[text()='Sort by:']/following-sibling::div"));
		act.click(popularity).perform();
		WebElement price=driver.findElement(By.xpath("//li[contains(.,'Low To High')]"));
		act.click(price).perform();
		Thread.sleep(1000);
		WebElement lowval=driver.findElement(By.xpath("(//div[@class='filter-inner']/div)[1]"));
		//WebElement highval=driver.findElement(By.xpath("//div[@class='filter-inner']/div/a[2]"));
	    //int width =lowval.getSize().width;
		act.dragAndDropBy(lowval,2,0).perform();
		//WebElement color=driver.findElement(By.xpath("//label[@for='Color_s-Navy']//a"));
		//act.click(color).perform();
		WebElement firstimg=driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
		act.moveToElement(firstimg).perform();
		Thread.sleep(1000);
		WebElement quickview=driver.findElement(By.xpath("(//div[contains(text(),'Quick')])[1]"));
		act.click(quickview).perform();
		Set <String> windowhandle=driver.getWindowHandles();
	     List<String> winhand=new ArrayList<>(windowhandle);
	     driver.switchTo().window(winhand.get(0));
		Thread.sleep(1000);
	    WebElement cost=driver.findElement(By.xpath("//span[@class='payBlkBig']"));
	    System.out.println("Cost of the shoe :"+cost.getText());
	    WebElement discount=driver.findElement(By.xpath("//span[@class='percent-desc ']"));
	    System.out.println("Discount value :"+discount.getText());
	    Thread.sleep(3000);
	 WebElement imag=driver.findElement(By.xpath("//img[@slidenum='3']"));
	    File source=  imag.getScreenshotAs(OutputType.FILE);
	    File destn=new File("./screen/shoe.png");
	    FileUtils.copyFile(source, destn);
	    
		
		
	
		
				

	}

}
