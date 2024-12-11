package com.fgrea.features.ui.route

import com.fgrea.features.ui.UiController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.uiRoutes(controller: UiController) {
    route("/ui") {
        get("/{componentName}") {
            controller.getComponentByName(call)
        }
    }
}