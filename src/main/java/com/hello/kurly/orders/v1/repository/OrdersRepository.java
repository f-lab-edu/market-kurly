package com.hello.kurly.orders.v1.repository;

import com.hello.kurly.orders.domain.Orders;
import com.hello.kurly.products.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface OrdersRepository extends JpaRepository<Orders, BigInteger> {

}
