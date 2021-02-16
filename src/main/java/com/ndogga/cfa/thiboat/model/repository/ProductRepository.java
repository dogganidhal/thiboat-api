package com.ndogga.cfa.thiboat.model.repository;


import com.ndogga.cfa.thiboat.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author nidhaldogga
 * @created 16/02/2021 10:00
 * SoftKall™ All rights reserved.
 */


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
