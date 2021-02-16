package com.ndogga.cfa.thiboat.service.impl;


import com.ndogga.cfa.thiboat.model.entity.Product;
import com.ndogga.cfa.thiboat.model.repository.ProductRepository;
import com.ndogga.cfa.thiboat.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * @author nidhaldogga
 * @created 16/02/2021 14:04
 * SoftKall™ All rights reserved.
 */


@Service
@AllArgsConstructor
public class PromotionServiceImpl implements PromotionService {

  private final ProductRepository productRepository;

  @Override
  public Product applyPromotionWhenApplies(Product product) {
    Product maybeOnPromotionProduct = product;
    if (product.getRemainingQuantity() >= 64) {
      maybeOnPromotionProduct = productRepository.save(product
              .withOnSale(true)
              .withDiscount(product.getPrice() * 0.5f)
      );
    } else if (product.getRemainingQuantity() >= 16) {
      maybeOnPromotionProduct = productRepository.save(product
              .withOnSale(true)
              .withDiscount(product.getPrice() * 0.8f)
      );
    }
    return maybeOnPromotionProduct;
  }

}
