package br.com.acrf.shoppingservice.productcatalog.controller;

import br.com.acrf.shoppingservice.productcatalog.entity.Product;
import br.com.acrf.shoppingservice.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Product updateById(@PathVariable Long id, @RequestBody Product product) throws Exception {
        return productService.updateById(id, product);
    }

    public void deleteById(@PathVariable long id) throws Exception{
        productService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Product> findAll(){
        return productService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Product findById(@PathVariable Long id) throws Exception{
        return productService.findById(id);
    }
}
