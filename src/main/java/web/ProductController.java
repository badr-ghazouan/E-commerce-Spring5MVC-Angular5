package web;

import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repositories.ProductRepository;

import java.util.List;

public class ProductController {


    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/product/",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product product)
    {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/product/{id}",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void findProduct(@PathVariable("id") Long id)
    {
        productRepository.findById(id);
    }

    @RequestMapping(value = "/product/",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findProductes()
    {
        return productRepository.findAll();
    }

    @RequestMapping(value = "/product/{id}",
            method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@PathVariable("id") long id,
                              @RequestBody Product product)
    {
        Product currentProduct = productRepository.getOne(id);
        currentProduct.setDescription(product.getDescription());
        currentProduct.setName(product.getName());
        productRepository.save(currentProduct);
    }

    @RequestMapping(value = "/product/{id}",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id)
    {
        productRepository.deleteById(id);
    }

    @RequestMapping(value = "/product/",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllProductes()
    {
        productRepository.deleteAll();
    }
}
