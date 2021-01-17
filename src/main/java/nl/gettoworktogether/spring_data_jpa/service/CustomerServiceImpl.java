package nl.gettoworktogether.spring_data_jpa.service;

import nl.gettoworktogether.spring_data_jpa.exceptions.RecordNotFoundException;
import nl.gettoworktogether.spring_data_jpa.model.Customer;
import nl.gettoworktogether.spring_data_jpa.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Collection<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Collection<Customer> getCustomersByLastName(String name) {
        return customerRepository.findAllByLastName(name);
    }

    @Override
    public long createCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }

    @Override
    public void updateCustomer(long id, Customer newCustomer) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        Customer customer = customerRepository.findById(id).get();
        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> getCustomerById(long id) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        return customerRepository.findById(id);
    }

    @Override
    public boolean customerExistsById(long id) {
        return customerRepository.existsById(id);
    }

}