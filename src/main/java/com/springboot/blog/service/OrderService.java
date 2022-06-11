package com.springboot.blog.service;

import com.springboot.blog.payload.OrderRequest;
import com.springboot.blog.payload.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
