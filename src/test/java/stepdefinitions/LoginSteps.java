package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private String title;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    String url = "https://app.cfe.mx/Aplicaciones/CCFE/MiEspacio/Login.aspx";
		DriverFactory.getDriver().get(url);
	    System.out.println(url + " is now open");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	   title = loginPage.getLoginPageTitle();
	   System.out.println("Page title is " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("¿Olvidaste tu contraseña? link should be displayed")
	public void olvidaste_tu_contraseña_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkPresent());
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
	    loginPage.enterUserName(userName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	   loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    loginPage.clickOnLogin();
	}

	



}
