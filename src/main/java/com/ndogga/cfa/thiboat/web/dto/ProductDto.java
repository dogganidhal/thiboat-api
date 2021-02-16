package com.ndogga.cfa.thiboat.web.dto;


import com.ndogga.cfa.thiboat.model.entity.Product;
import lombok.Builder;
import lombok.Data;


/**
 * @author nidhaldogga
 * @created 16/02/2021 09:44
 * SoftKall™ All rights reserved.
 */


@Data
@Builder
public class ProductDto {
  private Integer id;
  private String name;
  private Float price;
  private String unit;
  private Boolean available;
  private Boolean onSale;
  private Float discount;
  private String comments;
  private String owner;
  private Integer remainingQuantity;

  public static ProductDto from(Product product) {
    return ProductDto.builder()
            .id(product.getId())
            .name(product.getName())
            .price(product.getPrice())
            .unit(product.getUnit())
            .available(product.getAvailable())
            .onSale(product.getOnSale())
            .discount(product.getDiscount())
            .comments(product.getComments())
            .owner(product.getOwner())
            .remainingQuantity(product.getRemainingQuantity())
            .build();
  }
}
