package com.order.backend.product

import com.order.backend.order.OrderEntity
import jakarta.persistence.*

@Entity
data class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val name: String,

    val price: Double,

    @ManyToOne
    @JoinColumn(name = "order_id")
    val order: OrderEntity? = null
) {
}