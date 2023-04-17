package com.hello.kurly.products.v1.repository;

import com.hello.kurly.products.domain.SubProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubProductRepository extends JpaRepository<SubProduct, Long> {

}
