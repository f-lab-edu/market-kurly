package com.hello.kurly.users.domain;

import com.hello.kurly.products.domain.Product;
import com.hello.kurly.products.domain.Seller;
import com.hello.kurly.products.domain.Storage;
import com.hello.kurly.products.domain.SubProduct;
import com.hello.kurly.products.v1.repository.ProductRepository;
import com.hello.kurly.products.v1.repository.SellerRepository;
import com.hello.kurly.products.v1.repository.StorageRepository;
import com.hello.kurly.products.v1.repository.SubProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.hello.kurly.factory.ProductFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {

  @Autowired
  ProductRepository productRepository;
  @Autowired
  SubProductRepository subProductRepository;

  @Autowired
  SellerRepository sellerRepository;

  @Autowired
  StorageRepository storageRepository;

  private Product testProduct;
  private SubProduct testSubProduct;

  private Seller testSeller;

  private Storage testStorage;

  @BeforeEach
  public void setUp() {
    testProduct = createProduct();
    testSubProduct = createSubProduct();
    testStorage = createStorage();
    testSeller = createSeller();

    productRepository.save(testProduct);
//    subProductRepository.save(testSubProduct);
//    sellerRepository.save(testSeller);
//    storageRepository.save(testStorage);

    testProduct.addSubProduct(testSubProduct);
    testProduct.addSeller(testSeller);
    testProduct.addStorage(testStorage);
    productRepository.save(testProduct);
  }

  @Test
  @DisplayName("상품에 대한 정보를 조회한다")
  void findById() {
    Optional<Product> getProduct = productRepository.findById(testProduct.getId());
    assertThat(getProduct.get().getId()).isEqualTo(testProduct.getId());
  }

  @Test
  @DisplayName("상품에 대한 하위 상품들을 조회한다")
  void findSubProductByProductId() {
    List<SubProduct> findSubProduct = testProduct.getSubProducts();
    assertThat(findSubProduct.get(0)).isEqualTo(testSubProduct);
  }

  @Test
  @DisplayName("상품에 대한 속성들을 변경한다")
  void modifyProductField() {
    // 상품 설명 변경
    String changeShortDesc = "테스트용으로 변경된 설명";
    testProduct.modifyShortDescription(changeShortDesc);
    assertThat(testProduct.getShortDescription()).isEqualTo(changeShortDesc);

    // 유통기한 변경
    LocalDateTime changeExpirationDate = LocalDateTime.of(2024,6,26,23,59,59);
    testProduct.modifyExpiration(changeExpirationDate);
    assertThat(testProduct.getExpirationDate()).isEqualTo(changeExpirationDate);

    // 상품 이미지 URL 주소 변경
    String changeMainImageUrl = "http://test.test.img";
    testProduct.modifyMainImageUrl(changeMainImageUrl);
    assertThat(testProduct.getMainImageUrl()).isEqualTo(changeMainImageUrl);
  }

  @Test
  @DisplayName("상품에 대한 판매자를 조회한다")
  void findSeller() {
    assertThat(testProduct.getSeller()).isEqualTo(testSeller);
  }

  @Test
  @DisplayName("상품에 대한 판매자에 대한 세팅을 한후 판매자 엔티티에서 상품을 조회한다")
  void findProductIdBySellerEntity() {
    List<Product> products = testSeller.getProducts();

    assertThat(products).contains(testProduct);
  }

  @AfterEach
  public void cleanUp() {
    productRepository.delete(testProduct);
  }
}
