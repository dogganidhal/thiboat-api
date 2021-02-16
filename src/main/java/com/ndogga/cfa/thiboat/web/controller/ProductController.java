package com.ndogga.cfa.thiboat.web.controller;


import com.ndogga.cfa.thiboat.service.ProductService;
import com.ndogga.cfa.thiboat.web.dto.AlterStockRequest;
import com.ndogga.cfa.thiboat.web.dto.ProductDto;
import com.ndogga.cfa.thiboat.web.dto.PutOnSaleRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author nidhaldogga
 * @created 16/02/2021 09:44
 * SoftKall™ All rights reserved.
 */


@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  @GetMapping
  ResponseEntity<Collection<ProductDto>> listProducts() {
    return ResponseEntity.ok(productService.listProducts().stream()
            .map(ProductDto::from)
            .collect(Collectors.toList())
    );
  }

  @GetMapping("/{id}")
  ResponseEntity<ProductDto> productById(@PathVariable Integer id) {
    return productService.productById(id)
            .map(product -> ResponseEntity.ok(ProductDto.from(product)))
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}/sale")
  ResponseEntity<ProductDto> putProductOnSale(@PathVariable Integer id, @RequestBody PutOnSaleRequest request) {
    return productService.putProductOnSale(id, request.getDiscount())
            .map(product -> ResponseEntity.ok(ProductDto.from(product)))
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}/sale")
  ResponseEntity<ProductDto> removeProductSale(@PathVariable Integer id) {
    return productService.removeProductSale(id)
            .map(product -> ResponseEntity.ok(ProductDto.from(product)))
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}/stock")
  ResponseEntity<ProductDto> increaseStock(@PathVariable Integer id, @RequestBody AlterStockRequest request) {
    return productService.increaseProductStock(id, request.getDelta())
            .map(product -> ResponseEntity.ok(ProductDto.from(product)))
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}/stock")
  ResponseEntity<ProductDto> decreaseStock(@PathVariable Integer id, @RequestBody AlterStockRequest request) {
    return productService.decreaseProductStock(id, request.getDelta())
            .map(product -> ResponseEntity.ok(ProductDto.from(product)))
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

}
