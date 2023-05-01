package com.base;


	import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		
		public static WebDriver driver;

		public static void getDriver() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		public static void enterUrl(String url) {
			driver.get(url);
		}

		public static void maximizeWindow() {
			driver.manage().window().maximize();
		}

		
		public static void implicitWait() {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}

		public static void elementVisibility(WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(element));
		}

		public static void elementSendKeys(WebElement element, String data) {
			elementVisibility(element);
			element.sendKeys(data);
		}

		public static void elementSendKeysJs(WebElement element, String data) {
			elementVisibility(element);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguements[0].setAttribute('value','" + data + "')", element);
		}

		public static void elementClick(WebElement element) {
			elementVisibility(element);
			element.click();
		}

		public static String getWindowTitle() {
			String title = driver.getTitle();
			return title;
		}

		public static WebElement findElementById(String attributeValue) {
			WebElement element = driver.findElement(By.id(attributeValue));
			return element;
		}

		public static WebElement findElementByName(String attributeValue) {
			WebElement element = driver.findElement(By.name(attributeValue));
			return element;
		}

		public static WebElement findElementByClassName(String attributeValue) {
			WebElement element = driver.findElement(By.className(attributeValue));
			return element;
		}

		public static WebElement findElementByXpath(String attributeValue) {
			WebElement element = driver.findElement(By.xpath(attributeValue));
			return element;
		}

		public static WebElement findElementByCssSelector(String attributeValue) {
			WebElement element = driver.findElement(By.cssSelector(attributeValue));
			return element;
		}

		public static WebElement findElementBylinkText(String attributeValue) {
			WebElement element = driver.findElement(By.linkText(attributeValue));
			return element;
		}

		public static WebElement findElementByPartialLinkText(String attributeValue) {
			WebElement element = driver.findElement(By.partialLinkText(attributeValue));
			return element;
		}

		public static WebElement findElementByTagName(String attributeValue) {
			WebElement element = driver.findElement(By.tagName(attributeValue));
			return element;
		}

		public static void enter() throws AWTException {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}

		public static void sleep(long a) throws InterruptedException {
			Thread.sleep(a);
		}

		public static void closeWindow() {
			driver.close();
		}

		public static void quitWindow() {
			driver.quit();
		}

		public static String elementGetText(WebElement element) {
			elementVisibility(element);
			String text = element.getText();
			return text;
		}

		// 99% value --> get inserted value from textbox
		public static String elementGetAttributeValue(WebElement element) {
			elementVisibility(element);
			String attribute = element.getAttribute("value");
			return attribute;
		}

		// 1% value --> get inserted value from textbox
		public static String elementGetAttributeValue(WebElement element, String attributeName) {
			elementVisibility(element);
			String attribute = element.getAttribute(attributeName);
			return attribute;
		}

		public static void selectOptionByText(WebElement element, String text) {
			elementVisibility(element);
			Select select = new Select(element);
			select.selectByVisibleText(text);
		}

		public static void selectOptionByAttribute(WebElement element, String value) {
			elementVisibility(element);
			Select select = new Select(element);
			select.selectByValue(value);
		}

		public static void selectOptionByIndex(WebElement element, int index) {
			elementVisibility(element);
			Select select = new Select(element);
			select.selectByIndex(index);
		}

		public static String getOptions(WebElement element) {
			elementVisibility(element);
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			WebElement webElement = options.get(5);
			String text = webElement.getText();
			return text;
		}

		public static String getAllSelectedOptions(WebElement element) {
			elementVisibility(element);
			Select select = new Select(element);
			List<WebElement> options = select.getAllSelectedOptions();
			String text = options.get(1).getText();
			return text;
		}

		public static String getFirstSelectedOption(WebElement element) {
			elementVisibility(element);
			Select select = new Select(element);
			WebElement options = select.getFirstSelectedOption();
			String text = options.getText();
			return text;
		}

		public static void isMultiple(WebElement element) {
			elementVisibility(element);
			Select select = new Select(element);
			select.isMultiple();
		}

		public static void deSelectOptionByText(WebElement element, String text) {
			elementVisibility(element);
			Select select = new Select(element);
			select.deselectByVisibleText(text);
		}

		public static void deSelectOptionByAttribute(WebElement element, String value) {
			elementVisibility(element);
			Select select = new Select(element);
			select.deselectByValue(value);
		}

		public static void deSelectOptionByIndex(WebElement element, int index) {
			elementVisibility(element);
			Select select = new Select(element);
			select.deselectByIndex(index);
		}

		public static void deSelectAll(WebElement element) {
			elementVisibility(element);
			Select select = new Select(element);
			select.deselectAll();
		}

		public static String elementGetText(WebElement element, String value) {
			elementVisibility(element);
			String text = element.getAttribute(value);
			return text;
		}

		public static void elementClickButtonByJs(WebElement element) {
			elementVisibility(element);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguements[0].click()", element);
		}

		public static void clickOkAlert() {
			driver.switchTo().alert().accept();
		}

		public static void clickCancelAlert() {
			driver.switchTo().alert().dismiss();
		}

		public static void acceptAndOkAlert(String data) {
			driver.switchTo().alert().sendKeys(data);
			driver.switchTo().alert().accept();
		}

		public static void swtichToFrameByIndex(int index) {
			driver.switchTo().frame(index);
		}

		public static void switchToFrameById(String id) {
			driver.switchTo().frame(id);
		}

		public static void switchToMainPageFromFrame() {
			driver.switchTo().defaultContent();
		}

		public static String getParentWindowId() {
			String id = driver.getWindowHandle();
			return id;
		}

		public static Set<String> getAllWindowsId() {
			Set<String> id = driver.getWindowHandles();
			return id;
		}

		public static void switchToWindowById(String Id) {
			driver.switchTo().window(Id);
		}

		public static void switchToWindowByTitle(String title) {
			driver.switchTo().window(title);
		}

		public static void switchTowindowByUrl(String url) {
			driver.switchTo().window(url);
		}

		public static void navigateBack() {
			driver.navigate().back();
		}

		public static void navigateForward() {
			driver.navigate().forward();
		}

		public static void navigateRefresh() {
			driver.navigate().refresh();
		}

		public static void navigateToUrl(String url) {
			driver.navigate().to(url);
		}

		public static void moveToElement(WebElement element) {
			elementVisibility(element);
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		}

		public static void dragAndDrop(WebElement element1, WebElement element2) {
			elementVisibility(element1);
			elementVisibility(element2);
			Actions action = new Actions(driver);
			action.dragAndDrop(element1, element2).perform();
		}

		public static void takeScreenShotElement(WebElement element) {
			elementVisibility(element);
			File src = element.getScreenshotAs(OutputType.FILE);
			
		}

		public static byte[] screenshot() {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
			return screenshotAs;
		}

		public static void rightClick(WebElement element) {
			elementVisibility(element);
			Actions action = new Actions(driver);
			action.contextClick(element).perform();
		}

		public static void doubleClick(WebElement element) {
			elementVisibility(element);
			Actions action = new Actions(driver);
			action.doubleClick(element).perform();
		}

		public static String getPageSource() {
			String text = driver.getPageSource();
			return text;
		}

		public static String getTagName(WebElement element) {
			elementVisibility(element);
			String text = element.getTagName();
			return text;
		}

		public static String getCssValue(WebElement element, String value) {
			elementVisibility(element);
			String text = element.getCssValue(value);
			return text;
		}

		public static Dimension getSize(WebElement element) {
			elementVisibility(element);
			Dimension size = element.getSize();
			return size;
		}

		public static void getConnection(String url) throws SQLException {
			DriverManager.getConnection(url);
		}

		public static void clear(WebElement element) {
			elementVisibility(element);
			element.clear();
		}

		public static boolean isEnabled(WebElement element) {
			elementVisibility(element);
			boolean enabled = element.isEnabled();
			return enabled;
		}

		public static boolean isDisplayed(WebElement element) {
			elementVisibility(element);
			boolean displayed = element.isDisplayed();
			return displayed;
		}

		public static void submit(WebElement element) {
			elementVisibility(element);
			element.submit();
		}

		public static String getProjectPath() {
			String path = System.getProperty("user.dir");
			return path;
		}

		public static String getPropertyFileValue(String Key) throws FileNotFoundException, IOException {
			Properties properties = new Properties();
			properties.load(new FileInputStream(getProjectPath() + "\\config\\config.properties"));
			String value = (String) properties.get(Key);
			return value;
		}

		public static void getDriver(String browserType) {
			switch (browserType) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			default:
				break;
			}
		}

	


}
