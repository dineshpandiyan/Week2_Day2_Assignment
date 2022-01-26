package week2.day2.assignments.completed;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_DuplicateLead {

	public static void main(String[] args) {
		// Assignment 2 : Duplicate Lead
		
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
		
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String name = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[text()='First Name']")).getText();
		System.out.println(name);
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[text()='First Name']")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		
		String expectedTitle = "Duplicate Lead | opentaps CRM";
		
		if(actualTitle.equals(expectedTitle)) {
			
			System.out.println("Actual & Expected title are same");
			
		}else {
			
			System.out.println("Actual & Expected title are not same");
			
		}
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		String dupName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		System.out.println(dupName);
		
		if(name.equals(dupName)) {
			
			System.out.println("Both values are same");			
			
		}else {
			
			System.out.println("Both values are not same");
			
		}
		
		driver.close();
		
		

	}

}
