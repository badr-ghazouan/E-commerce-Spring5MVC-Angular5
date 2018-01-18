package web;

import entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repositories.OrderRepository;

import java.util.List;

public class OrderController {


    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/order/",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Order saveOrder(@RequestBody Order order)
    {
        return orderRepository.save(order);
    }

    @RequestMapping(value = "/order/{id}",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void findOrder(@PathVariable("id") Long id)
    {
        orderRepository.findById(id);
    }

    @RequestMapping(value = "/order/",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Order> findOrderes()
    {
        return orderRepository.findAll();
    }

    @RequestMapping(value = "/order/{id}",
            method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateOrder(@PathVariable("id") long id,
                              @RequestBody Order order)
    {
        Order currentOrder = orderRepository.getOne(id);

        currentOrder.setOrderDate(order.getOrderDate());
        currentOrder.setCustomer(order.getCustomer());
        currentOrder.setAddress(order.getAddress());

        orderRepository.save(currentOrder);
    }

    @RequestMapping(value = "/order/{id}",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("id") Long id)
    {
        orderRepository.deleteById(id);
    }

    @RequestMapping(value = "/order/",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllOrderes()
    {
        orderRepository.deleteAll();
    }
}
