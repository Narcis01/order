package com.order.backend.order.rest

import com.order.backend.order.OrderResource
import com.order.backend.order.service.OrderServiceImp
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderControllerImp(
    val orderServiceImp: OrderServiceImp
): OrderController {

    @PostMapping("/order")
    override fun create(orderResource: OrderResource): OrderResource {
        return orderServiceImp.create(orderResource.toWrapper()).toResource()
    }

    @DeleteMapping("/order/{id}")
    override fun delete(@PathVariable id: Long) {
        val order = orderServiceImp.getOrder(id)
        orderServiceImp.delete(order)
    }

    @GetMapping("/order/{id}")
    override fun getOrder(@PathVariable id: Long): OrderResource {
        return orderServiceImp.getOrder(id).toResource()
    }

    @GetMapping
    override fun getOrders(): List<OrderResource> {
        return orderServiceImp.getOrders().map { it.toResource() }
    }
}