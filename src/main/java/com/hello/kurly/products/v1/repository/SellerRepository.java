package com.hello.kurly.products.v1.repository;

import com.hello.kurly.products.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
