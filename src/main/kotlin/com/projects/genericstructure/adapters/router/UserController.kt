package com.projects.genericstructure.adapters.router

import com.projects.genericstructure.adapters.router.request.CreateUserRequest
import com.projects.genericstructure.adapters.router.request.CreateUserResponse
import com.projects.genericstructure.adapters.router.request.toCommand
import com.projects.genericstructure.adapters.router.request.toCreateUserResponse
import com.projects.genericstructure.core.service.user.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    suspend fun createUser(@RequestBody request: CreateUserRequest): CreateUserResponse {
        val userId = UUID.randomUUID()
        val user = userService.create(request.toCommand(userId))
        return user.toCreateUserResponse()
    }

    @PutMapping("/{userId}/enable")
    @ResponseStatus(HttpStatus.OK)
    suspend fun enableUser(@PathVariable("userId") userId: UUID) {
        userService.enable(userId)
    }

    @PutMapping("/{userId}/disable")
    @ResponseStatus(HttpStatus.OK)
    suspend fun disableUser(@PathVariable("userId") userId: UUID) {
        userService.disable(userId)
    }
}
