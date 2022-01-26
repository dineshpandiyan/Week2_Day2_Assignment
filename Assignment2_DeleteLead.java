package week2.day2.assignments.completed;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_DeleteLead {

	public static void main(String[] args) {
		// Assignment2 : Delete Lead
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		String url = "http://leaftaps.com/opentaps/control/main";
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9999999999");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String fId = driver.findElement(By.xpath("//a[text()='11435']")).getText();
		System.out.println(fId);
		
		driver.findElement(By.xpath("//a[text()='11435']")).click();
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys("11435");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String noRec = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		System.out.println(noRec + " or Records Deleted");
		
		driver.close();
		
		
	}

}
