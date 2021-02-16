package com.ndogga.cfa.thiboat.service;


import com.ndogga.cfa.thiboat.model.entity.Product;

import java.util.Collection;
import java.util.Optional;

/**
 * @author nidhaldogga
 * @created 16/02/2021 10:01
 * SoftKall™ All rights reserved.
 */


public interface ProductService {
  Collection<Product> listProducts();
  Optional<Product> productById(Integer id);
  Optional<Product> putProductOnSale(Integer id, Float discount);
  Optional<Product> removeProductSale(Integer id);
  Optional<Product> increaseProductStock(Integer id, Integer delta);
  Optional<Product> decreaseProductStock(Integer id, Integer delta);
}
