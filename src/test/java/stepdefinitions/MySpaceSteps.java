package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.MySpacePage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MySpaceSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private MySpacePage mySpacePage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
	  List<Map<String, String>> userCredentials = dataTable.asMaps(); 
	  String userName = userCredentials.get(0).get("username");
	  String password = userCredentials.get(0).get("password");
	  
	  DriverFactory.getDriver().get("https://app.cfe.mx/Aplicaciones/CCFE/MiEspacio/Login.aspx");
	  mySpacePage = loginPage.signIn(userName, password);
	  
	}

	@Given("user is on My Space page")
	public void user_is_on_my_space_page() {
	    String title = mySpacePage.getMySpacePageTitle();
	    System.out.println("Page title is " + title);
	}

	@Then("user gets account section")
	public void user_gets_account_section(DataTable dataTable) {
		//Expected
		List<String> expectedList = dataTable.asList();
		System.out.println("Expected sections are " +  expectedList);
		
		//Actual
		List<String> actualList = mySpacePage.getAccountSectionsList();
		System.out.println("Expected sections are " +  actualList);
		
		Assert.assertEquals(expectedList, actualList);
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedCount) {
	   Assert.assertTrue(mySpacePage.getAccountSectionsCount() == expectedCount);
	}



}
