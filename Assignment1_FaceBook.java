package week2.day2.assignments.completed;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_FaceBook {

	public static void main(String[] args) {
		// Assignment1 : FaceBook
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		String url = "https://en-gb.facebook.com/";
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Dineshpandiyan");
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Subramanian");
		
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9999999999");
		
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Password@123");
		
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select d1 = new Select(day);
		d1.selectByIndex(18);
		
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select m1 = new Select(month);
		m1.selectByVisibleText("Feb");
		
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select y1 = new Select(year);
		y1.selectByVisibleText("1986");
		
		driver.findElement(By.xpath("//input[@value='2']")).click();

	}

}
