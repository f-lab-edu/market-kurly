package com.hello.kurly.products.v1.service;

import com.hello.kurly.common.exception.ProductNotFoundException;
import com.hello.kurly.products.domain.Product;
import com.hello.kurly.products.v1.dto.ProductResponseDto;
import com.hello.kurly.products.v1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@RequiredArgsConstructor
@Service
@Transactional
public class ProductService {

  private final ProductRepository productRepository;

  public ProductResponseDto getProduct(Long id) {
    Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());
    return ProductResponseDto.from(product);
  }
}
