package cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

class Customer {
    private String firstName, lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}


public class createCustomerDefs {



    String firstName;
    String lastName;
    Customer customer;

    @Given("customers first name is {string}")
    public void first_name_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        firstName = string;
    }

    @Given("customers last name is {string}")
    public void last_name_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        lastName = string;
    }

    @Given("work time between {int}:{int} AM and {int}:{int} PM")
    public void work_time_between_am_and_pm(Integer int1, Integer int2, Integer int3, Integer int4) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Create a new customer")
    public void create_a_new_customer() {
        // Write code here that turns the phrase above into concrete actions
        customer = new Customer(firstName, lastName);

        }
    }
