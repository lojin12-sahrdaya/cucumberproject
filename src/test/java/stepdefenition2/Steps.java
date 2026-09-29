package stepdefenition2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps  {
	 WebDriver driver;
	 @Given("user is on the SauceDemo login page")
	 public void setup() {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.saucedemo.com/");
	 }
	 @When("user enters valid username and password")
	 public void logincredentials() {
		 driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	 }
	 @And("clicks on the login button")
	 public void submit() {
		 driver.findElement(By.xpath("//input[@id='login-button']")).click();
	 }
	 @Then("user should be redirected to the home page")
	 public void validation() {
		 String url = driver.getCurrentUrl();
		 if(url.contains("inventory")) {
			 System.out.println("Login Successfull");
		 }
		 else {
			 System.out.println("Login is not successfull");
		 }
	 }
	 @When("user adds three products to the cart")
	 public void addcart() {
		 driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		 driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
		 driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
	 }
	 @And("user removes one product from the cart")
	 public void removeitem() {
		 driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
	 }
	 @And("user goes to the cart page")
	 public void cart() {
		 driver.findElement(By.className("shopping_cart_link")).click();
	 }
	 @And("user proceeds to checkout")
	 public void checkout() {
		 driver.findElement(By.xpath("//button[@id='checkout']")).click(); 
		 driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("lojin"); 
		 driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("paul"); 
		 driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("12345");
		 driver.findElement(By.xpath("//input[@id='continue']")).click();
	 }
	 @And("user clicks the finish button")
	 public void finish(){
		 driver.findElement(By.xpath("//button[@id='finish']")).click();
	 }
	 @Then("user clicks on back to home button")
	 public void backhome() {
		 driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
		 String url1 = driver.getCurrentUrl();
		 if(url1.contains("inventory")) {
			 System.out.println("user reached back to home successfully");
		 }
		 else {
			 System.out.println("user not reached to home");
		 }
	 }
	 @And("browser is closed")
	 public void close() {
		 driver.quit();
	 }
}
