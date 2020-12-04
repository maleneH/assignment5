package servicelayer.customer;

import datalayer.customer.CustomerStorage;
import dto.Customer;
import dto.CustomerCreation;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public class CustomerServiceImpl implements CustomerService {

    private CustomerStorage customerStorage;

    public CustomerServiceImpl(CustomerStorage customerStorage) {
        this.customerStorage = customerStorage;
    }

    @Override
    public int createCustomer(String firstName, String lastName, Date birthdate) throws CustomerServiceException {
        try {
            return customerStorage.createCustomer(new CustomerCreation(firstName, lastName));
        } catch (SQLException throwables) {
            throw new CustomerServiceException("Wrong phone-number");
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        return null;
    }

    @Override
    public Collection<Customer> getCustomersByFirstName(String firstName) {
        return null;
    }
}
