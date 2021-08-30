package br.com.acrf.shoppingservice.shoppingcart.controller;

import br.com.acrf.shoppingservice.shoppingcart.entity.Cart;
import br.com.acrf.shoppingservice.shoppingcart.entity.Item;
import br.com.acrf.shoppingservice.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Cart addItem(@PathVariable Long id, @RequestBody Item item) throws Exception {
        Cart savedCart = cartService.findById(id);
        Cart cart;

        List<Item> itemList = new ArrayList<>();
        itemList.add(item);

        if (savedCart.equals(Optional.empty())){
            cart = new Cart(id);
        } else {
            cart = savedCart;
        }
        cart.getItems().add(item);
        return cartService.create(cart);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cart findById(@PathVariable Long id) throws Exception {
        return cartService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) throws Exception {
        cartService.deleteById(id);
    }
}
