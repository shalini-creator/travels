package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signup extends Base {
	WebDriver driver;
	Properties prop;

	public signup(WebDriver driver) {
		this.driver=driver;
		
	}
	By fname=By.xpath("//input[@placeholder='First Name']");
	By lname=By.xpath("//input[@placeholder='Last Name']");
	By mobilenumber=By.xpath("//input[@placeholder='Mobile Number']");
	By email=By.xpath("//input[@placeholder='Email']");
	By password=By.xpath("//input[@placeholder='Password']");
	By confirmpass=By.xpath("//input[@placeholder='Confirm Password']");
	By Cookie = By.xpath("//button[@id='cookyGotItBtn']");
	By btn = By.xpath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']");
	public void signupform() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\sree\\travel\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		driver.findElement(Cookie).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(fname).sendKeys(prop.getProperty("fname"));
		driver.findElement(lname).sendKeys(prop.getProperty("lname"));
		driver.findElement(mobilenumber).sendKeys(prop.getProperty("mobilenumber"));
		driver.findElement(email).sendKeys(prop.getProperty("email"));
		driver.findElement(password).sendKeys(prop.getProperty("password"));
		driver.findElement(confirmpass).sendKeys(prop.getProperty("confirmpass"));
		driver.findElement(btn).click();
	}	
		
	}

