package com.order.backend.order

import com.order.backend.product.ProductEntity
import com.order.backend.user.UserEntity
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
            user = this.user
        )
    }
}

data class OrderWrapper(val address: String, val products: List<ProductEntity>, val user: UserEntity?){
    fun toEntity(): OrderEntity{
        return OrderEntity(
            address = this.address,
            products = this.products,
            user = this.user
        )
    }

    fun toResource(): OrderResource{
        return OrderResource(
            address = this.address,
            products = this.products,
            user = this.user
        )
    }
}

data class OrderResource(val address: String, val products: List<ProductEntity>, val user: UserEntity?){
    fun toWrapper(): OrderWrapper{
        return OrderWrapper(
            address = this.address,
            products = this.products,
            user = this.user
        )
    }
}