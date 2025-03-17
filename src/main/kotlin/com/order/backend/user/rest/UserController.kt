package com.order.backend.user.rest

import com.order.backend.user.UserResource

interface UserController {
    fun create(userResource: UserResource): UserResource

    fun delete(id: Long)

    fun getUser(id: Long): UserResource

    fun getUsers(): List<UserResource>
}