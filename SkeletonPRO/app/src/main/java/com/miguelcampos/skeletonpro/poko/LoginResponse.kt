package com.miguelcampos.skeletonpro.poko

data class LoginResponse(
    val active: Boolean,
    val created: String,
    val email: String,
    val photoUrl: String,
    val token: String,
    val username: String
)