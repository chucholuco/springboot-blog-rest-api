package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Order;
import com.springboot.blog.entity.Payment;
import com.springboot.blog.exception.PaymentException;
import com.springboot.blog.payload.OrderRequest;
import com.springboot.blog.payload.OrderResponse;
import com.springboot.blog.repository.OrderRepository;
import com.springboot.blog.repository.PaymentRepository;
import com.springboot.blog.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);
        LOG.info("Saving Order in Database");

        Payment payment = orderRequest.getPayment();

        if (!payment.getType().equals("DEBIT")) {
            LOG.error("Payment card type do not support");
            throw new PaymentException("Payment card type do not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        LOG.info("Saving Payment in Database");

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;

    }
}
