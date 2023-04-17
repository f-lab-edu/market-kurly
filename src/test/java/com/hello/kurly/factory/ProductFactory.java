package com.hello.kurly.factory;

import com.hello.kurly.products.domain.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ProductFactory {

  public static Product createProduct() {
    ArrayList<SubProduct> subProducts = new ArrayList<>();
    subProducts.add(createSubProduct());
    return new Product().builder()
//            .id(3L)
//            .storage(new Storage())
//            .seller(new Seller())
//            .subProducts(subProducts)
            .shortDescription("테스트용 상품 설명")
            .sellerName("마켓컬리")
            .deliveryTypeName("냉장")
            .expirationDate(LocalDateTime.of(2023,5,25,23,59,59))
            .mainImageUrl("https://img-cf.kurly.com/cdn-cgi/image/quality=85,width=120/shop/data/goods/1643865296932l0.jpg")
            .build();
  }

  public static SubProduct createSubProduct() {
    return new SubProduct().builder()
//            .id(3L)
//            .product(new Product())
//            .category(createCategory())
            .name("테스트 하위 상품")
            .brand("테스트 하위 상품 브랜드")
            .tag("#테스트 #하위상품")
            .basePrice(BigInteger.valueOf(10000))
            .retailPrice(BigInteger.valueOf(8000))
            .discountRate(20)
            .discountedPrice(BigInteger.valueOf(2000))
            .restock(100)
            .canRestockNotify(true)
            .minQuantity(1)
            .maxQuantity(9999)
            .isSoldOut(false)
            .isPurchaseStatus(true)
            .isExpectedPoint(true)
            .mainImageUrl("https://img-cf.kurly.com/cdn-cgi/image/quality=85,width=120/shop/data/goods/1643865296932l0.jpg")
            .build();
  }

  public static Category createCategory() {
    return new Category();
  }

  public static Storage createStorage() {
    return new Storage();
  }

  public static Seller createSeller() {
    return new Seller();
  }
}
