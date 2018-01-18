package web;

import entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import repositories.ItemRepository;

import java.util.List;

public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping(value = "/item/",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Item saveItem(@RequestBody Item item)
    {
        return itemRepository.save(item);
    }

    @RequestMapping(value = "/item/{id}",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void findItem(@PathVariable("id") Long id)
    {
        itemRepository.findById(id);
    }

    @RequestMapping(value = "/item/",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Item> findItemes()
    {
        return itemRepository.findAll();
    }

    @RequestMapping(value = "/item/{id}",
            method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateItem(@PathVariable("id") long id,
                               @RequestBody Item item)
    {
        Item currentItem = itemRepository.getOne(id);
        currentItem.setImagePATH(item.getImagePATH());
        currentItem.setName(item.getName());
        currentItem.setUnitCost(item.getUnitCost());
        itemRepository.save(currentItem);
    }

    @RequestMapping(value = "/item/{id}",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable("id") Long id)
    {
        itemRepository.deleteById(id);
    }

    @RequestMapping(value = "/item/",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllItemes()
    {
        itemRepository.deleteAll();
    }

}
