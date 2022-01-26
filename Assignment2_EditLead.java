package week2.day2.assignments.completed;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_EditLead {

	public static void main(String[] args) {
		// Assignment2 : Edit Lead
		
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
		
		driver.findElement(By.xpath("//div[@class='x-form-element'][@id='x-form-el-ext-gen248']/input[@name='firstName']")).sendKeys("firstName");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		driver.findElement(By.xpath("//a[text()='10682']")).click();
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		
		String expectedTitle = "View Lead | opentaps CRM";
		
		if(actualTitle.equals(expectedTitle)) {
			
			System.out.println("Title is as Expected");
			
		}else {
			
			System.out.println("Title is not as Expected");
			
		}
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		WebElement cName = driver.findElement(By.id("updateLeadForm_companyName"));
		cName.clear();
		cName.sendKeys("CompanyName1");
		
		driver.findElement(By.xpath("//input[@class='smallSubmit'][@value = 'Update']")).click();
		
		String updateCName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(updateCName);
		
		driver.close();
		

	}

}
