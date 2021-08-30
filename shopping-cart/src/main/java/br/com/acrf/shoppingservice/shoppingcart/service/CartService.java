package br.com.acrf.shoppingservice.shoppingcart.service;

import br.com.acrf.shoppingservice.shoppingcart.entity.Cart;
import br.com.acrf.shoppingservice.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private final CartRepository cartRepository;


    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart create(Cart cart){
        return cartRepository.save(cart);
    }

    public Cart updateById(Long id, Cart cart) throws Exception {
        Cart cartFindById = cartRepository.findById(id)
                .orElseThrow(() -> new Exception(String.format("Cart with %s not found!", id)));

        return cartRepository.save(cart);
    }

    public void deleteById(Long id) throws Exception {
        Cart cartFindById = cartRepository.findById(id)
                .orElseThrow(() -> new Exception(String.format("Cart with %s not found!", id)));

        cartRepository.deleteById(id);
    }

    public Iterable<Cart> findAll(){
        return cartRepository.findAll();
    }

    public Cart findById(long id) throws Exception {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new Exception(String.format("Cart with %s not found!", id)));

        return cart;
    }
}
