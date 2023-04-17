package com.hello.kurly.products.v1.repository;

import com.hello.kurly.products.domain.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage, Long> {
}

