package web;

import entities.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repositories.CreditCardRepository;

import java.util.List;

public class CreditCardController {



    @Autowired
    CreditCardRepository creditCardRepository;

    @RequestMapping(value = "/creditCard/",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard saveCreditCard(@RequestBody CreditCard creditCard)
    {
        return creditCardRepository.save(creditCard);
    }

    @RequestMapping(value = "/creditCard/{id}",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void findCreditCard(@PathVariable("id") Long id)
    {
        creditCardRepository.findById(id);
    }

    @RequestMapping(value = "/creditCard/",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCard> findCreditCardes()
    {
        return creditCardRepository.findAll();
    }

    @RequestMapping(value = "/creditCard/{id}",
            method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateCreditCard(@PathVariable("id") long id,
                               @RequestBody CreditCard creditCard)
    {
        CreditCard currentCreditCard = creditCardRepository.getOne(id);
        currentCreditCard.setCreditCardExpiryDate(creditCard.getCreditCardExpiryDate());
        currentCreditCard.setCreditCardNumber(creditCard.getCreditCardNumber());
        currentCreditCard.setCreditCardType(creditCard.getCreditCardType());
        creditCardRepository.save(currentCreditCard);
    }

    @RequestMapping(value = "/creditCard/{id}",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCreditCard(@PathVariable("id") Long id)
    {
        creditCardRepository.deleteById(id);
    }

    @RequestMapping(value = "/creditCard/",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllCreditCardes()
    {
        creditCardRepository.deleteAll();
    }

}
