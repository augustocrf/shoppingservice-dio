package br.com.acrf.shoppingservice.shoppingcart.repository;

import br.com.acrf.shoppingservice.shoppingcart.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository  extends CrudRepository<Item, Long> {
}
