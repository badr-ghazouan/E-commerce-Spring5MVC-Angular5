package web;

import entities.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repositories.OrderLineRepository;

import java.util.List;

public class OrderLineController {

    @Autowired
    OrderLineRepository orderLineRepository;

    @RequestMapping(value = "/orderLine/",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderLine saveOrderLine(@RequestBody OrderLine orderLine)
    {
        return orderLineRepository.save(orderLine);
    }

    @RequestMapping(value = "/orderLine/{id}",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void findOrderLine(@PathVariable("id") Long id)
    {
        orderLineRepository.findById(id);
    }

    @RequestMapping(value = "/orderLine/",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderLine> findOrderLinees()
    {
        return orderLineRepository.findAll();
    }

    @RequestMapping(value = "/orderLine/{id}",
            method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateOrderLine(@PathVariable("id") long id,
                               @RequestBody OrderLine orderLine)
    {
        OrderLine currentOrderLine = orderLineRepository.getOne(id);
        currentOrderLine.setQuantity(orderLine.getQuantity());
        orderLineRepository.save(currentOrderLine);
    }

    @RequestMapping(value = "/orderLine/{id}",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderLine(@PathVariable("id") Long id)
    {
        orderLineRepository.deleteById(id);
    }

    @RequestMapping(value = "/orderLine/",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllOrderLinees()
    {
        orderLineRepository.deleteAll();
    }

}
