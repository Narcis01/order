package com.order.backend.user

import com.order.backend.order.OrderEntity
import com.order.backend.order.OrderResource
import com.order.backend.order.OrderWrapper
import jakarta.persistence.*

@Entity
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val username: String,

    val password: String,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val orders: List<OrderEntity>
) {
    fun toWrapper(): UserWrapper{
        return UserWrapper(
            username = this.username,
            password = this.password,
            orders = this.orders.map { it.toWrapper() }
        )
    }
}

data class UserWrapper(val username: String, val password: String, val orders: List<OrderWrapper>){
    fun toEntity(): UserEntity{
        return UserEntity(
            username = this.username,
            password = this.password,
            orders = this.orders.map { it.toEntity() }
        )
    }

    fun toResource(): UserResource{
        return UserResource(
            username = this.username,
            password = this.password,
            orders = this.orders.map { it.toResource() }
        )
    }
}

data class UserResource(val username: String, val password: String, val orders: List<OrderResource>){

    fun toWrapper(): UserWrapper{
        return UserWrapper(
            username = this.username,
            password = this.password,
            orders = this.orders.map { it.toWrapper() }
        )
    }
}