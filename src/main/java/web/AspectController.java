package web;

import entities.Address;
import entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import pojos.Concept;
import repositories.AddressRepository;
import repositories.OrderRepository;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Date;

@Transactional
@Controller
public class AspectController {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OrderRepository orderRepository;


    @RequestMapping(value = "/aspects",
                    method = RequestMethod.GET,
                    produces = "application/json")
    public @ResponseBody Concept aspects()
    {
        Concept concept = new Concept();

        concept.setDefinition("an abstraction of a real phenomenon");
        concept.setDomain("Semantics");
        concept.setParent("Thought");

        Order order = new Order();

        order.setAddress(null);
        order.setCustomer(null);
        order.setOrderDate(new Date());

        orderRepository.save(order);

        System.out.println(orderRepository.findById(new Long(1)));

        return concept;
    }

}
