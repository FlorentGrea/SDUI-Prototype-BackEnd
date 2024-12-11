package com.fgrea.features.ui

import kotlinx.serialization.json.Json
import com.fgrea.features.ui.service.UiService
import com.fgrea.features.ui.model.UIComponent
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.http.*
import kotlinx.serialization.builtins.ListSerializer

typealias Queries = Map<String, Any>

class UiController(private val service: UiService) {

    private fun parseNestedQueries(params: Parameters): Queries {
        return params.entries()
            .filter { it.key != "componentName" }
            .associate { (key, values) ->
                val value = values.first()
                try {
                    // Try to parse as JSON if it looks like a nested structure
                    if (value.startsWith("{") && value.endsWith("}")) {
                        key to Json.decodeFromString<Map<String, String>>(value)
                    } else {
                        key to value
                    }
                } catch (e: Exception) {
                    key to value
                }
            }
    }

    suspend fun getComponentByName(call: ApplicationCall) {
        val componentName = call.parameters["componentName"]
        if (componentName == null) {
            call.respond(HttpStatusCode.BadRequest, "Missing component name")
            return
        }

        val queries = parseNestedQueries(call.request.queryParameters)
        val components = service.getComponentByName(componentName, queries)
        
        if (components.isNotEmpty()) {
            val json = Json.encodeToString(ListSerializer(UIComponent.serializer()), components)
            call.respondText(json, ContentType.Application.Json)
        } else {
            call.respond(HttpStatusCode.NotFound, "Component not found")
        }
    }
}