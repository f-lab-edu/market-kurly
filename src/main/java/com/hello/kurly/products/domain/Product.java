package com.hello.kurly.products.domain;

import com.hello.kurly.common.model.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Table(name = "products")
@Entity
@Builder
public class Product extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // 상위 상품 pk

  @OneToOne(fetch = LAZY)
  @JoinColumn(name = "storage_id", referencedColumnName = "id")
  private Storage storage;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "seller_id")
  private Seller seller;

  @OneToMany(fetch = LAZY, mappedBy = "product")
  private List<SubProduct> subProducts = new ArrayList<>();

  private String shortDescription; //상품 설명

  private String sellerName; // 판매처

  private String deliveryTypeName; // 배송 타입

  private LocalDateTime expirationDate; // 유통기한

  private String mainImageUrl; // 이미지 URL 주소

  public Product(Long id,
                  Storage storage,
                  Seller seller,
                  List<SubProduct> subProducts,
                  String shortDescription,
                  String sellerName,
                  String deliveryTypeName,
                  LocalDateTime expirationDate,
                  String mainImageUrl) {
    this.id = id;
    this.storage = storage;
    this.seller = seller;
    this.subProducts = subProducts;
    this.shortDescription = shortDescription;
    this.sellerName = sellerName;
    this.deliveryTypeName = deliveryTypeName;
    this.expirationDate = expirationDate;
    this.mainImageUrl = mainImageUrl;
  }

  public void addSubProduct(SubProduct subProduct) {
    if(this.subProducts == null) {
      this.subProducts = new ArrayList<>();
    }
    this.subProducts.add(subProduct);
  }

  public void addSeller(Seller seller) {
    this.seller = seller;
  }

  public void addStorage(Storage storage) {
    this.storage = storage;
  }

  public void modifyShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public void modifyExpiration(LocalDateTime expirationDate) {
    this.expirationDate = expirationDate;
  }

  public void modifyMainImageUrl(String mainImageUrl) {
    this.mainImageUrl = mainImageUrl;
  }
}
