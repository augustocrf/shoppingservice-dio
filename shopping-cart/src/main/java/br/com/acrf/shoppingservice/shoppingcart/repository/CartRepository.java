package br.com.acrf.shoppingservice.shoppingcart.repository;

import br.com.acrf.shoppingservice.shoppingcart.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository  extends CrudRepository<Cart, Long> {
}
