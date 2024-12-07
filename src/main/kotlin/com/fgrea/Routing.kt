package com.fgrea

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.fgrea.features.ui.uiRoutes

fun Application.configureRouting() {
    routing {
        // Hello World route
        get("/") {
            call.respondText("Hello World!")
        }
        
        // UI routes
        uiRoutes()
    }
}
