package com.fgrea.plugins


import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.fgrea.features.ui.route.uiRoutes
import com.fgrea.features.ui.UiController
import com.fgrea.features.ui.service.UiService

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause" , status = HttpStatusCode.InternalServerError)
        }
    }
    // Dependency injection for service and controller
    val uiService = UiService()
    val uiController = UiController(uiService)

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        // Add UI-related routes
        uiRoutes(uiController)

        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}