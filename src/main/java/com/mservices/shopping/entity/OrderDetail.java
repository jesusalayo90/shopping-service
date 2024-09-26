package com.mservices.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table(name = "orderDetail")
public class OrderDetail {

    @Getter(onMethod_ = {@Id, @GeneratedValue(strategy = GenerationType.IDENTITY), @Column(name = "orderDetailId")})
    private Integer id;
    private String productId;
    private String variationId;
    private Float quantity;
    private Float price;

}
