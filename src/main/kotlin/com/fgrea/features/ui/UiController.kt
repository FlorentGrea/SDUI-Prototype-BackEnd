package com.fgrea.features.ui

import io.ktor.server.plugins.statuspages.*
import com.fgrea.features.ui.service.UiService
import com.fgrea.features.ui.model.UIComponent
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.http.*

class UiController(private val service: UiService) {

    suspend fun getComponentByName(call: ApplicationCall) {
        val componentName = call.parameters["componentName"]
        if (componentName == null) {
            call.respond(HttpStatusCode.BadRequest, "Missing component name")
            return
        }

        val component = service.getComponentByName(componentName)
        if (component != null) {
            call.respond(component)
        } else {
            call.respond(HttpStatusCode.NotFound, "Component not found")
        }
    }
}