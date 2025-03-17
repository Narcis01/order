package com.order.backend.order.rest

import com.order.backend.order.OrderResource
import com.order.backend.order.service.OrderService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderControllerImp(
    val orderService: OrderService
): OrderController {

    @PostMapping("/order")
    override fun create(@RequestBody orderResource: OrderResource): OrderResource {
        return orderService.create(orderResource.toWrapper()).toResource()
    }

    @DeleteMapping("/order/{id}")
    override fun delete(@PathVariable id: Long) {
        val order = orderService.getOrder(id)
        orderService.delete(order)
    }

    @GetMapping("/order/{id}")
    override fun getOrder(@PathVariable id: Long): OrderResource {
        return orderService.getOrder(id).toResource()
    }

    @GetMapping
    override fun getOrders(): List<OrderResource> {
        return orderService.getOrders().map { it.toResource() }
    }
}