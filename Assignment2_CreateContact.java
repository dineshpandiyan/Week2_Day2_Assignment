package week2.day2.assignments.completed;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_CreateContact {

	public static void main(String[] args) {
		// Assignment2 : Create Contact
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		String url = "http://leaftaps.com/opentaps/control/login";
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();		
		driver.findElement(By.linkText("Contacts")).click();		
		driver.findElement(By.linkText("Create Contact")).click();
		
		driver.findElement(By.id("firstNameField")).sendKeys("First Name");
		driver.findElement(By.id("lastNameField")).sendKeys("Last Name");
		
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("First Name L");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Last Name L");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Department");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Description");		
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("test@test.com");
		
		WebElement source = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select s1 = new Select(source);
		s1.selectByVisibleText("New York");
		
		driver.findElement(By.className("smallSubmit")).click();
		
		driver.findElement(By.className("subMenuButton")).click();
		
		WebElement desc = driver.findElement(By.id("updateContactForm_description"));
		desc.clear();
		
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Important Info!!!");
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		

	}

}
