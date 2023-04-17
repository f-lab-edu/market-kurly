package com.hello.kurly.products.v1.controller;

import com.hello.kurly.products.v1.dto.ProductResponseDto;
import com.hello.kurly.products.v1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {

  private final ProductService productService;

  @GetMapping("/{id}")
  public ProductResponseDto getProduct(@PathVariable Long id) {
    return productService.getProduct(id);
  }
}
