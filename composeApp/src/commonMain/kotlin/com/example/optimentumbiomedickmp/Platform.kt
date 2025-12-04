package com.example.optimentumbiomedickmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform