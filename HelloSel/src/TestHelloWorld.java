import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//testcomment
//test comment from a different source
public class TestHelloWorld {

	WebDriver browser;
	WebElement textfield;
	WebElement button;
	WebElement output;
	
	@BeforeEach
	public void init_browser() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/cbobak/eclipse-workspace/HelloSel/drv/chromedriver.exe");
		browser = new ChromeDriver();
	}
	
	@AfterEach
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
