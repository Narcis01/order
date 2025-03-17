package com.order.backend.user.service

import com.order.backend.user.UserRepository
import com.order.backend.user.UserWrapper
import org.springframework.stereotype.Service


@Service
class UserServiceImp(
    val userRepository: UserRepository
): UserService {
    override fun create(userWrapper: UserWrapper): UserWrapper {
        return userRepository.save(userWrapper.toEntity()).toWrapper()
    }

    override fun delete(id: Long) {
        userRepository.deleteById(id)
    }

    override fun getUser(id: Long): UserWrapper {
        return userRepository.findById(id).get().toWrapper()
    }

    override fun getUsers(): List<UserWrapper> {
        return userRepository.findAll().map { it.toWrapper() }
    }
}