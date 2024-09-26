package com.mservices.shopping.repository;

import com.mservices.shopping.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Optional<Order> findBySerialAndDeleted(String serial, Boolean deleted);
}
