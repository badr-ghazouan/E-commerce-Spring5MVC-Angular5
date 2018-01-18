package web;

import entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repositories.CategoryRepository;

import java.util.List;

public class CategoryController {


    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/category/",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Category saveCategory(@RequestBody Category category)
    {
        return categoryRepository.save(category);
    }

    @RequestMapping(value = "/category/{id}",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void findCategory(@PathVariable("id") Long id)
    {
        categoryRepository.findById(id);
    }

    @RequestMapping(value = "/category/",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Category> findCategoryes()
    {
        return categoryRepository.findAll();
    }

    @RequestMapping(value = "/category/{id}",
            method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateCategory(@PathVariable("id") long id,
                              @RequestBody Category category)
    {
        Category currentCategory = categoryRepository.getOne(id);
        currentCategory.setDescription(category.getDescription());
        currentCategory.setName(category.getName());
        categoryRepository.save(currentCategory);
    }

    @RequestMapping(value = "/category/{id}",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable("id") Long id)
    {
        categoryRepository.deleteById(id);
    }

    @RequestMapping(value = "/category/",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllCategoryes()
    {
        categoryRepository.deleteAll();
    }

}
