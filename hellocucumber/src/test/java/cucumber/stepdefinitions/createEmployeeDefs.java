package cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Employee {
    private String firstName, lastName;
    private LocalTime start, end;


    public Employee(String firstName, String lastName, LocalTime start, LocalTime end) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.start = start;
        this.end = end;
    }
}


public class createEmployeeDefs {

    String firstName;
    String lastName;
    LocalTime workingTimeStart;
    LocalTime workingTimeEnd;

    Employee employee;

    @Given("employees first name is {string}")
    public void first_name_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        firstName = string;
    }

    @Given("employees last name is {string}")
    public void last_name_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        lastName = string;
    }

    @Given("work time is between {string} and {string}")
    public void work_time_is_between_and(String startTime, String endTime) {
        // Write code here that turns the phrase above into concrete actions
        workingTimeStart = LocalTime.parse(startTime);
        workingTimeEnd = LocalTime.parse(endTime);
    }



    @Then("create a new employee")
    public void create_a_new_employee() {
        // Write code here that turns the phrase above into concrete actions
        employee = new Employee(firstName, lastName, workingTimeStart, workingTimeEnd);

    }
}
