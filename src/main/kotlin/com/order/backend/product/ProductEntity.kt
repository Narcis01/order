package com.order.backend.product

import com.order.backend.order.OrderEntity
import com.order.backend.order.OrderResource
import com.order.backend.order.OrderWrapper
import jakarta.persistence.*

@Entity
data class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    val price: Double,

    @ManyToOne
    @JoinColumn(name = "order_id")
    val order: OrderEntity? = null
) {
    fun toWrapper(): ProductWrapper{
        return ProductWrapper(
            name = this.name,
            price = this.price,
            order = this.order?.toWrapper()
        )
    }
}

data class ProductWrapper(val name: String, val price: Double, val order: OrderWrapper?){
    fun toEntity(): ProductEntity{
        return ProductEntity(
            name = this.name,
            price = this.price,
            order = this.order?.toEntity()
        )
    }

    fun toResource(): ProductResource{
        return ProductResource(
            name = this.name,
            price = this.price,
            order = this.order?.toResource()
        )
    }
}

data class ProductResource(val name: String, val price: Double, val order: OrderResource?){
    fun toWrapper(): ProductWrapper{
        return ProductWrapper(
            name = this.name,
            price = this.price,
            order = this.order?.toWrapper()
        )
    }
}