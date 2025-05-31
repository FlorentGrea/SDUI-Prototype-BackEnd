package com.fgrea.features.ui.route

import com.fgrea.features.ui.UiController
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.http.*
import java.io.File

fun Route.uiRoutes(controller: UiController) {
    route("/ui") {
        get("/{componentName}") {
            controller.getComponentByName(call)
        }
        
        get("/styles/web") {
            val file = File("src/main/kotlin/com/fgrea/uiArchitecture/styles/WebStyle.json")
            if (file.exists()) {
                call.respondText(file.readText(), ContentType.Application.Json)
            } else {
                call.respond(HttpStatusCode.NotFound, "Style file not found")
            }
        }
    }
}