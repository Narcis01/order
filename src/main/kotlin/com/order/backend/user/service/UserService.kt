package com.order.backend.user.service

import com.order.backend.user.UserWrapper

interface UserService {
    fun create(userResource: UserWrapper): UserWrapper

    fun delete(id: Long)

    fun getUser(id: Long): UserWrapper

    fun getUsers(): List<UserWrapper>
}