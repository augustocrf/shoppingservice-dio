package br.com.acrf.shoppingservice.productcatalog.repository;

import br.com.acrf.shoppingservice.productcatalog.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
