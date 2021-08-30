package br.com.acrf.shoppingservice.shoppingcart.service;

import br.com.acrf.shoppingservice.shoppingcart.entity.Cart;
import br.com.acrf.shoppingservice.shoppingcart.entity.Item;
import br.com.acrf.shoppingservice.shoppingcart.repository.CartRepository;
import br.com.acrf.shoppingservice.shoppingcart.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item create(Item item){
        return itemRepository.save(item);
    }

    public Item updateById(Long id, Item item) throws Exception {
        Item itemFindById = itemRepository.findById(id)
                .orElseThrow(() -> new Exception(String.format("Item with %s not found!", id)));

        return itemRepository.save(item);
    }

    public void deleteById(Long id) throws Exception {
        Item itemFindById = itemRepository.findById(id)
                .orElseThrow(() -> new Exception(String.format("Item with %s not found!", id)));

        itemRepository.deleteById(id);
    }

    public Iterable<Item> findAll(){
        return itemRepository.findAll();
    }

    public Item findById(long id) throws Exception {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new Exception(String.format("Item with %s not found!", id)));

        return item;
    }
}
