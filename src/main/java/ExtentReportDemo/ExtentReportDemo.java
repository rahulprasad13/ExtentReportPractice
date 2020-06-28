package ExtentReportDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config(){
		
		//Two classes to remember ExtentReports ,ExtentSparkReporter
		
		// directory where output is to be printed
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rahul Kumar");
	}
	
	@Test
	public void intialDemo()
	{
		ExtentTest test=extent.createTest("intialDemo");
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Docs\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println("Navigated to mentioned URL");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Result do not match");
		extent.flush();
	}

}
