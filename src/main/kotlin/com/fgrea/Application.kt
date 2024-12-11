package com.fgrea

import io.ktor.server.application.*
import com.fgrea.plugins.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
    configureHTTP()
}