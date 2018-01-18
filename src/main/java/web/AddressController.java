package web;


import entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repositories.AddressRepository;

import java.util.List;

@Controller
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @RequestMapping(value = "/address/",
                    method = RequestMethod.POST,
                    consumes = "application/json",
                    produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Address saveAddress(@RequestBody Address address)
    {
        return addressRepository.save(address);
    }

    @RequestMapping(value = "/address/{id}",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void findAddress(@PathVariable("id") Long id)
    {
        addressRepository.findById(id);
    }

    @RequestMapping(value = "/address/",
                    method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Address> findAddresses()
    {
        return addressRepository.findAll();
    }

    @RequestMapping(value = "/address/{id}",
                    method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateAddress(@PathVariable("id") long id,
                              @RequestBody Address address)
    {
        Address currentAddress = addressRepository.getOne(id);
        currentAddress.setZipCode(address.getZipCode());
        currentAddress.setStreet1(address.getStreet1());
        currentAddress.setStreet2(address.getStreet2());
        currentAddress.setState(address.getState());
        currentAddress.setCity(address.getCity());
        currentAddress.setCountry(address.getCountry());
        addressRepository.save(currentAddress);
    }

    @RequestMapping(value = "/address/{id}",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable("id") Long id)
    {
        addressRepository.deleteById(id);
    }

    @RequestMapping(value = "/address/",
                    method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllAddresses()
    {
        addressRepository.deleteAll();
    }
}
