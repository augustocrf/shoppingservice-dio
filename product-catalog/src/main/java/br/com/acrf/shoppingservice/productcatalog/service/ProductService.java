package br.com.acrf.shoppingservice.productcatalog.service;

import br.com.acrf.shoppingservice.productcatalog.entity.Product;
import br.com.acrf.shoppingservice.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    public Product updateById(Long id, Product product) throws Exception {
        Product productFindById = productRepository.findById(id)
                .orElseThrow(() -> new Exception(String.format("Product with %s not found!", id)));

        return productRepository.save(product);
    }

    public void deleteById(Long id) throws Exception {
        Product productFindById = productRepository.findById(id)
                .orElseThrow(() -> new Exception(String.format("Product with %s not found!", id)));

        productRepository.deleteById(id);
    }

    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(long id) throws Exception {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new Exception(String.format("Product with %s not found!", id)));

        return product;
    }
}
