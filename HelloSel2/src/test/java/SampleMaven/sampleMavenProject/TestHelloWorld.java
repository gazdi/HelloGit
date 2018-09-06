package SampleMaven.sampleMavenProject;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHelloWorld {

	WebDriver browser;
	WebElement textfield;
	WebElement button;
	WebElement output;
	
	@Before
	public void init_browser() {
		String osname =System.getProperty("os.name");
		
		if (osname.startsWith("Windows")) {
			System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
		}
		else {
			System.setProperty("webdriver.chrome.driver", "drv/chromedriver");
		}
		browser = new ChromeDriver();
	}
	
	@After
	public void close_browser() {
		browser.close();
	}
	
	@Test 
	public void page_has_necessary_elements() {
		browser.get("https://s3.amazonaws.com/asadcloudguru1234/index.html");
		
		try {
			textfield = browser.findElement(By.id("textbox"));
			button = browser.findElement(By.tagName("button"));
			//output = browser.findElement(By.id("my-demo"));
			output = browser.findElement(By.tagName("h1"));
		}
		catch (NoSuchElementException e) {
			fail("Element(s) not found.");
		}
		
		assertNotNull(textfield);
		assertNotNull(button);
		assertNotNull(output);
	}

	@Test
	public void input_buttonpress_output() throws InterruptedException {
		page_has_necessary_elements();
		textfield.sendKeys("World!");
		button.click();
		Thread.sleep(2000);
		try {
			output.getText();
		}
		catch (UnhandledAlertException e) {
			browser.switchTo().alert().accept();
		}
		assertEquals("Hello WORLD!", output.getText());
	}
	
}
