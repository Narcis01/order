package com.order.backend.order.rest

import com.order.backend.order.OrderResource

interface OrderController {
    fun create(orderResource: OrderResource): OrderResource

    fun delete(id: Long)

    fun getOrder(id: Long): OrderResource

    fun getOrders(): List<OrderResource>

}