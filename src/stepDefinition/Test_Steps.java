package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {

	public static WebDriver driver;

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://advantageonlineshopping.com/");
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() {
		WebElement botaoLogin = driver.findElement(By.id("hrefUserIcon"));
		botaoLogin.click();
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		driver.findElement(By.name("username")).sendKeys("emerson.prado");
		driver.findElement(By.name("password")).sendKeys("Teste@1234");
		Thread.sleep(2000);
		driver.findElement(By.id("sign_in_btnundefined")).click();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Logado com sucesso!");
		Thread.sleep(2000);
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		driver.findElement(By.id("menuUserLink")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"loginMiniTitle\"]/label[3]")).click();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
		System.out.println("Deslogado com sucesso");
		Thread.sleep(2000);
	}

}
