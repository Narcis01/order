package com.order.backend.user.rest

import com.order.backend.user.UserResource
import com.order.backend.user.service.UserService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserControllerImp(
    val userService: UserService
): UserController {

    @PostMapping("/user")
    override fun create(@RequestBody userResource: UserResource): UserResource {
        return userService.create(userResource.toWrapper()).toResource()
    }

    @DeleteMapping("/user/{id}")
    override fun delete(@PathVariable id: Long) {
        userService.delete(id)
    }

    @GetMapping("/user/{id}")
    override fun getUser(@PathVariable id: Long): UserResource {
        return userService.getUser(id).toResource()
    }

    @GetMapping
    override fun getUsers(): List<UserResource> {
        return userService.getUsers().map { it.toResource() }
    }
}