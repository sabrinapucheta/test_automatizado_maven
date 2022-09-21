package sabrina;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.driver.DriverFactory;

public class NewTestDespegarSP {
	WebDriver driver;
	WebDriverWait wait;
	
	@Test
	public void validaciondespegar() throws Exception {
		driver=DriverFactory.levantarBrowser(driver, "CHROME", "https://www.despegar.com.ar/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		obtenerElement("//div[@class='login-incentive--header']//i[1]");

		obtenerElement("//a[@title='Alojamientos']");

		WebElement destino = obtenerElement(
				"//input[@placeholder='Ingresá una ciudad, alojamiento o punto de interés']");

		destino.sendKeys("Córdoba, Córdoba, Argentina");
		Thread.sleep(5000);
		destino.sendKeys(Keys.CONTROL);
		Thread.sleep(5000);
		destino.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
				
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,250)", "");
		
		obtenerElement("//input[@placeholder='Entrada']");
		
		LocalDate localdate = LocalDate.now();
		int diaactual = localdate.getDayOfMonth();
		obtenerElement("//*[@id='component-modals']/div[4]/div[1]/div[2]/div[1]/div[3]/div[" + diaactual + "]");

		obtenerElement("//*[@id='component-modals']/div[4]/div[1]/div[2]/div[1]/div[3]/div[" + (diaactual + 1) + "]");
		//Thread.sleep(5000);

		obtenerElement("//div[@class='sbox5-3-second-input-wrapper']");
		//Thread.sleep(5000);

		WebElement sumaradulto = driver.findElement(By.cssSelector(
				"#component-modals > div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened > div > div > div.stepper__room > div.stepper__distribution_container > div:nth-child(1) > div.stepper__room__row__stepper__contaer > div > button.steppers-icon-right.stepper__icon"));
		wait.until(ExpectedConditions.elementToBeClickable(sumaradulto));
		sumaradulto.click();
		//Thread.sleep(5000);

		obtenerElement("//*[@id='component-modals']/div[5]/div/div/div[1]/div[2]/div[2]/div[2]/div/button[2]");

		obtenerElement("//select[@class='select']");
		//Thread.sleep(5000);

		WebElement elegiredad = driver.findElement(By.xpath("//select[@class='select']"));
		wait.until(ExpectedConditions.elementToBeClickable(elegiredad));
		elegiredad.sendKeys("1 años");
		elegiredad.sendKeys(Keys.ENTER);

		JavascriptExecutor scroll1 = (JavascriptExecutor) driver;
		scroll1.executeScript("window.scrollBy(0,250)", "");

		obtenerElement(("(//a[@class='sbox5-3-btn -md -primary'])[2]"));
	//	Thread.sleep(5000);
		obtenerElement(("//button[@class='sbox5-box-button-ovr sbox5-3-btn sbox5-button -secondary -icon -lg']"));

		scroll.executeScript("window.scrollBy(0,250)", "");

		WebElement validacion1 = driver.findElement(By.xpath("//span[contains(text(),'Savannah Cordoba Hotel')]"));
		wait.until(ExpectedConditions.elementToBeClickable(validacion1));
		System.out.println("Texto encontrado:  " + validacion1.getText());
		Assert.assertTrue(validacion1.isDisplayed());
	
		driver.close();

	}

	private WebElement obtenerElement(String ruta) {
		WebElement webelement = driver.findElement(By.xpath(ruta));
		
		wait.until(ExpectedConditions.elementToBeClickable(webelement));
		webelement.click();
		return webelement;

	}
}
