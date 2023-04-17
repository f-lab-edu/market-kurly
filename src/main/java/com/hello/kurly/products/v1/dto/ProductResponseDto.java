package com.hello.kurly.products.v1.dto;

import com.hello.kurly.products.domain.Product;
import com.hello.kurly.products.domain.Seller;
import com.hello.kurly.products.domain.Storage;
import com.hello.kurly.products.domain.SubProduct;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductResponseDto {
  private Long id;
  private Storage storage;
  private Seller seller;
  private List<SubProduct> subProducts;
  private String shortDescription;
  private String sellerName;
  private String deliveryTypeName;
  private LocalDateTime expirationDate;
  private String mainImageUrl;

  public ProductResponseDto(Product product) {
    this.id = product.getId();
    this.storage = product.getStorage();
    this.seller = product.getSeller();
    this.subProducts = product.getSubProducts();
    this.shortDescription = product.getShortDescription();
    this.sellerName = product.getSellerName();
    this.deliveryTypeName = product.getDeliveryTypeName();
    this.expirationDate = product.getExpirationDate();
    this.mainImageUrl = product.getMainImageUrl();
  }

  public static ProductResponseDto from(Product product) {
    return new ProductResponseDto(product);
  }
}
