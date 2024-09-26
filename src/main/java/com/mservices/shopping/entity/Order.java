package com.mservices.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "`order`")
public class Order {

    @Getter(onMethod_ = {@Id, @GeneratedValue(strategy = GenerationType.IDENTITY), @Column(name = "orderId")})
    private Integer id;
    @Getter(onMethod_ = {@ManyToOne(fetch = FetchType.LAZY), @JoinColumn(name = "customerId", nullable = false)})
    private Customer customer;
    private String serial;
    @Getter(onMethod_ = @Enumerated(EnumType.STRING))
    private OrderStatus status;
    private Date createdAt;
    private Date updatedAt;
    private Boolean deleted;

    @Getter(onMethod_ = {@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY), @JoinColumn(name = "orderId", nullable = false)})
    private List<OrderDetail> details;

}
