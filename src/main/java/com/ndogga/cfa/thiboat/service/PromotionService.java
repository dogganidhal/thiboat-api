package com.ndogga.cfa.thiboat.service;


import com.ndogga.cfa.thiboat.model.entity.Product;


/**
 * @author nidhaldogga
 * @created 16/02/2021 14:04
 * SoftKall™ All rights reserved.
 */


public interface PromotionService {
  Product applyPromotionWhenApplies(Product product);
}
