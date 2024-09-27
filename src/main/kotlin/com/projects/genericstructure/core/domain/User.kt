package com.projects.genericstructure.core.domain

import java.util.UUID

data class User(
    val id: UUID,
    val email: String,
    val password: String,
    val enabled: Boolean,
    val roles: List<String>
)
