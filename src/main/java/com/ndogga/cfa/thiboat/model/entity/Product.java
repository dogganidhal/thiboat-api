package com.ndogga.cfa.thiboat.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author nidhaldogga
 * @created 16/02/2021 09:56
 * SoftKall™ All rights reserved.
 */


@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class Product {
  @Id
  @GeneratedValue
  private Integer id;
  @Column
  private String name;
  @Column
  private Float price;
  @Column
  private String unit;
  @Column
  private Boolean available;
  @Column(name = "on_sale")
  private Boolean onSale;
  @Column
  private Float discount;
  @Column
  private String comments;
  @Column
  private String owner;
  @Column(name = "remaining_quantity")
  private Integer remainingQuantity;
}
