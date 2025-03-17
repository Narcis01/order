package com.order.backend.order.service

import com.order.backend.order.OrderRepository
import com.order.backend.order.OrderWrapper
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class OrderServiceImp(
        val orderRepository: OrderRepository
): OrderService {
    override fun create(order: OrderWrapper): OrderWrapper {
        return orderRepository.save(order.toEntity()).toWrapper()
    }

    override fun delete(order: OrderWrapper) {
        orderRepository.delete(order.toEntity())
    }

    override fun getOrder(id: Long): OrderWrapper {
        return orderRepository.findById(id).get().toWrapper()
    }

    override fun getOrders(): List<OrderWrapper> {
        return orderRepository.findAll().map { it.toWrapper() }
    }
}