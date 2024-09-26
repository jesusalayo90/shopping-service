package com.mservices.shopping.controller;

import com.mservices.shopping.entity.Order;
import com.mservices.shopping.exception.ServiceException;
import com.mservices.shopping.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import static com.mservices.shopping.controller.util.BindingResultUtil.formatErrors;

@Controller
@RequestMapping(value = "/orders")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order, BindingResult validation)
            throws ServiceException {
        if (validation.hasErrors()) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, formatErrors(validation));
        }
        order = orderService.saveOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
