package com.order.backend.order.service

import com.order.backend.order.OrderWrapper

interface OrderService {
    fun create(order: OrderWrapper): OrderWrapper

    fun delete(order: OrderWrapper)

    fun getOrder(id: Long): OrderWrapper

    fun getOrders(): List<OrderWrapper>
}