import dto.Customer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {

    Customer customer = new Customer();


    @Given("First Name is {string}")
    public void firstNameIs(String arg0) {
        customer.setFirstname(arg0);
    }

    @And("Last Name is {string}")
    public void lastNameIs(String arg0) {
        customer.setLastname(arg0);
    }

    @When("I create customer")
    public void iCreateCustomer() {

    }

    @Then("I should receive a customer id\"")
    public void iShouldReceiveACustomerId() throws Throwable {
        // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    }



}
