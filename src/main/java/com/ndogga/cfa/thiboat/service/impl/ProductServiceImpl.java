package com.ndogga.cfa.thiboat.service.impl;

import com.ndogga.cfa.thiboat.model.entity.Product;
import com.ndogga.cfa.thiboat.model.repository.ProductRepository;
import com.ndogga.cfa.thiboat.service.ProductService;
import com.ndogga.cfa.thiboat.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;


/**
 * @author nidhaldogga
 * @created 16/02/2021 10:01
 * SoftKall™ All rights reserved.
 */


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final PromotionService promotionService;
  private final ProductRepository productRepository;

  @Override
  public Collection<Product> listProducts() {
    return productRepository.findAll();
  }

  @Override
  public Optional<Product> productById(Integer id) {
    return productRepository.findById(id);
  }

  @Override
  public Optional<Product> putProductOnSale(Integer id, Float discount) {
    return productRepository.findById(id)
            .map(product -> productRepository
                    .save(product
                            .withOnSale(true)
                            .withDiscount(discount)
                    )
            );
  }

  @Override
  public Optional<Product> removeProductSale(Integer id) {
    return productRepository.findById(id)
            .map(product -> productRepository
                    .save(product
                            .withOnSale(true)
                            .withDiscount(0.f)
                    )
            );
  }

  @Override
  @Transactional
  public Optional<Product> increaseProductStock(Integer id, Integer delta) {
    return productRepository.findById(id)
            .map(product -> productRepository
                    .save(product
                            .withAvailable(delta > 0 || product.getAvailable())
                            .withRemainingQuantity(product.getRemainingQuantity() + delta)
                    )
            )
            .map(promotionService::applyPromotionWhenApplies);
  }

  @Override
  @Transactional
  public Optional<Product> decreaseProductStock(Integer id, Integer delta) {
    return productRepository.findById(id)
            .map(product -> {
              if (delta > product.getRemainingQuantity()) {
                throw new IllegalArgumentException();
              }
              return productRepository
                      .save(product
                              .withAvailable(product.getRemainingQuantity() > delta)
                              .withRemainingQuantity(product.getRemainingQuantity() - delta)
                      );
            })
            .map(promotionService::applyPromotionWhenApplies);
  }

}
