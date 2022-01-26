package week2.day2.assignments.completed;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3_AcmeTestUrl {

	public static void main(String[] args) {
		// Assignment 3 : acme-test
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new  ChromeDriver();
		
		String url = "https://acme-test.uipath.com/login";
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		//driver.findElement(By.xpath("//button[@class='navbar-toggle']")).click();
		
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		
		driver.close();

	}

}
