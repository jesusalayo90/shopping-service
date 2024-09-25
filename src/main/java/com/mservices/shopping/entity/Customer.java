package com.mservices.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Entity
@Data
public class Customer {

    @Getter(onMethod_ = {@Id, @GeneratedValue(strategy = GenerationType.IDENTITY), @Column(name = "customerId")})
    private Integer id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private Date createdAt;
    private Date updatedAt;
    private Boolean deleted;

}
