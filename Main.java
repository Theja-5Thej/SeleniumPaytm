package Login.login1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Paytmlogin {
	@Test
	public static void main(String[] args) throws IOException, InterruptedException{
			Scanner s = new Scanner(System.in);
		System.setProperty("webdriver.chrome.driver", "F:\\java projec\\First_Selenium\\src\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://tickets.paytm.com/flights/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//SIgn-in
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/section/div/div")).click();
		driver.switchTo().frame(0);

		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/span/div/div/div[2]/span/a")).click();
		Thread.sleep(10000);
		
		///////////////
		//sending key values to search boxes and click on search
				driver.findElement(By.xpath("(//input[@id='text-box'])[1]")).sendKeys("Hyderabad");
				driver.findElements(By.xpath("//div[@class='wUyV']")).get(0).click();
				driver.findElement(By.xpath("(//input[@id='text-box'])[2]")).sendKeys("Delhi");
				driver.findElements(By.xpath("(//span[normalize-space()='Delhi,'])[1]")).get(0).click();
				driver.findElement(By.xpath("//*[@id=\"datePickerOnward\"]/div/div/input")).click();
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, 200);");
				driver.findElement(By.xpath("(//div[@class='G2sL'])[26]")).click();
				driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]")).click();

				//book now 
				driver.findElement(By.xpath("(//a[contains(text(),'Book')])[1]")).click();
				// Window Handeling
				 Set<String> windowHandl= driver.getWindowHandles();
					Iterator<String> iterate = windowHandl.iterator();
					String parentWin= iterate.next();
					String childWin= iterate.next();
					
					driver.switchTo().window(childWin);
					
					String flightName = driver.findElement(By.xpath("(//div[@class='_2kz0'])[1]")).getText();
					String flightId = driver.findElement(By.xpath("(//div[@class='_3qjA'])[1]")).getText();	
					String arrTime = driver.findElements(By.xpath("//div[@class='_171D']")).get(0).getText();
					String depTime = driver.findElements(By.xpath("//div[@class='_171D']")).get(1).getText();
					String datefull = driver.findElement(By.xpath("//body/div[@id='app']/div/div[@class='_1HKZ']/div/div[@class='_2Cmt']/div[@class='_-ZoM']/div[@class='_3_9L row']/div[@class='N9Zv']/div[@class='_2IC8']/div/div/div[@class='_2ZS3']/div[@class='_1Dh8']/div/div[@class='_2t8r row']/div[1]/div[3]")).getText();
					//Scroll
				
					jse.executeScript("scroll(0, 1500);");
					//continue button
//					driver.findElement(By.xpath("(//button[@class='button button--default _1YAy'][normalize-space()='Continue'])[1]")).click();
					
					
					//flling passenger details
					driver.findElement(By.xpath("(//div[normalize-space()='Mr'])[1]")).click();
					driver.findElement(By.xpath("(//div)[186]")).click();
					driver.findElements(By.xpath("//input[@class=\"fl-input\"]")).get(0).sendKeys("Thej");
//					driver.findElements(By.xpath("(//input[@type='text'])[2]")).get(1).click();
//					driver.findElement(By.xpath("(//input[@id='text-box'])[2]")).sendKeys("Thejeswar");
					driver.findElements(By.xpath("//div[@class=\"fl-input-container\"]")).get(3).click();
					driver.findElement(By.xpath("(//input[@id='text-box'])[4]")).sendKeys("thej@gmail.com");
					jse.executeScript("scroll(0, 200);");
//					driver.findElements(By.cssSelector("button[fdprocessedid='sldff']")).get(1).click();
					//Fetching baguage degtails
					driver.findElement(By.xpath("(//span[@class='_22d2 _2Mnp'])[1]")).click();
					int index = driver.findElements(By.xpath("//div[@class='_2AV5']")).size();
					String baguage=" ";
					for(int i=0;i<=5;i++) {
					
						baguage=baguage+driver.findElements(By.xpath("//div[@class='_2AV5']")).get(i).getText().substring(15)+"    @"+driver.findElements(By.xpath("//div[@class='_6JPL']")).get(i).getText()+" ,";
					}
					driver.findElement(By.xpath("(//span[@class='_22d2 _2Mnp'])[1]")).click();
					//Fetching the meal
					driver.findElement(By.xpath("(//span[@class='_22d2 _2Mnp'])[1]")).click();
					String meal=" ";
					for(int i=6;i<19;i++) {
						meal = meal+driver.findElements(By.xpath("//div[@class='_2AV5']")).get(i).getText()+"   @"+driver.findElements(By.xpath("//div[@class='_6JPL']")).get(i).getText()+" ,";
					}
					//ScreenShot
					File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					Files.copy(f, new File("C:\\Users\\Theja\\Downloads\\SampleScreenShot\\paytm.jpg"));
					System.out.println("Date: "+datefull.substring(6));
					System.out.println("FlightName: "+flightName);
					System.out.println("FlightID: "+flightId);
					System.out.println("ArrTime: "+arrTime);
					System.out.println("DepTime: "+depTime);
					System.out.println("Baguage :"+baguage);
					System.out.println("Meal :"+meal);
					
					driver.close();
				
	}
	
}
