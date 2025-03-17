package com.order.backend.order

import com.order.backend.product.ProductEntity
import com.order.backend.user.UserEntity
import com.order.backend.user.UserResource
import com.order.backend.user.UserWrapper
import jakarta.persistence.*

@Entity
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val address: String,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    val products: List<ProductEntity>,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity? = null
) {
    fun toWrapper(): OrderWrapper{
        return OrderWrapper(

            address = this.address,
            products = this.products,
            user = this.user?.toWrapper()
        )
    }
}

data class OrderWrapper(val address: String, val products: List<ProductEntity>, val user: UserWrapper?){
    fun toEntity(): OrderEntity{
        return OrderEntity(
            address = this.address,
            products = this.products,
            user = this.user?.toEntity()
        )
    }

    fun toResource(): OrderResource{
        return OrderResource(
            address = this.address,
            products = this.products,
            user = this.user?.toResource()
        )
    }
}

data class OrderResource(val address: String, val products: List<ProductEntity>, val user: UserResource?){
    fun toWrapper(): OrderWrapper{
        return OrderWrapper(
            address = this.address,
            products = this.products,
            user = this.user?.toWrapper()
        )
    }
}