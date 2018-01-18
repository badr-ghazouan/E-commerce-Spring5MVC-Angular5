package web;

import entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repositories.CustomerRepository;

import java.util.List;

public class CustomerController {


    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/customer/",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer customer)
    {
        return customerRepository.save(customer);
    }

    @RequestMapping(value = "/customer/{id}",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void findCustomer(@PathVariable("id") Long id)
    {
        customerRepository.findById(id);
    }

    @RequestMapping(value = "/customer/",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findCustomeres()
    {
        return customerRepository.findAll();
    }

    @RequestMapping(value = "/customer/{id}",
            method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer(@PathVariable("id") long id,
                              @RequestBody Customer customer)
    {
        Customer currentCustomer = customerRepository.getOne(id);

        currentCustomer.setFirstName(customer.getFirstName());
        currentCustomer.setLastName(customer.getLastName());
        currentCustomer.setEmail(customer.getEmail());
        currentCustomer.setTelephone(customer.getTelephone());
        currentCustomer.setLogin(customer.getLogin());
        currentCustomer.setPassword(customer.getPassword());
        currentCustomer.setBirthDate(customer.getBirthDate());

        customerRepository.save(currentCustomer);
    }

    @RequestMapping(value = "/customer/{id}",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("id") Long id)
    {
        customerRepository.deleteById(id);
    }

    @RequestMapping(value = "/customer/",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllCustomeres()
    {
        customerRepository.deleteAll();
    }
}
