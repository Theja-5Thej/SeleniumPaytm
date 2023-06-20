package p1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\java projec\\First_Selenium\\src\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://tickets.paytm.com/flights/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//sending key values to search boxes and click on search
		driver.findElement(By.xpath("(//input[@id='text-box'])[1]")).sendKeys("Bengaluru");
		driver.findElements(By.xpath("//span[@class=\"_2xZQ\"]")).get(0).click();
		driver.findElement(By.xpath("(//input[@id='text-box'])[2]")).sendKeys("Hyderabad");
		driver.findElements(By.xpath("(//span[normalize-space()='HYD'])[1]")).get(0).click();
		driver.findElement(By.xpath("(//img[@role='presentation'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='_9Hza'])[28]")).click();
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
			
			System.out.println("Date: "+datefull.substring(6)+"  :;  "+"FlightName: "+flightName+"  :;  "+"FlightID: "+flightId+"  :;  "+"ArrTime: "+arrTime+"  :;  "+"DepTime: "+depTime);
			driver.close();
		

	}

}
