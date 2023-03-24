package com.hello.kurly.products.v1.repository;

import com.hello.kurly.products.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ProductsRepository extends JpaRepository<Products, BigInteger> {

}
