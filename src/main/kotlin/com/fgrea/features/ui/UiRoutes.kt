package com.fgrea.features.ui

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.HttpStatusCode
import com.fgrea.features.ui.UiModel.UiResponse
import com.fgrea.features.ui.UiModel.UiComponent

// Define the type of functions in the registry
typealias ComponentFunction = (Map<String, String>) -> List<UiComponent>

// Simulating a component registry with functions
val componentRegistry: Map<String, ComponentFunction> = mapOf(
    "ComponentA" to { queries ->
        listOf(
            UiComponent(
                type = "ComponentA",
                props = queries.mapValues { (key, value) -> AnySerializable.Primitive(value) }
            )
        )
    },
    "ComponentB" to { queries ->
        listOf(
            UiComponent(
                type = "ComponentB",
                props = queries.mapValues { (key, value) -> AnySerializable.Primitive(value) }
            )
        )
    }
)

fun Route.uiRoutes() {
    route("/ui") {
        // GET endpoint for rendering UI components
        get("/{macroComponentName}/{otherQueries?}") {
            // Extract macroComponentName from the path
            val macroComponentName = call.parameters["macroComponentName"]

            // Extract all query parameters
            val queryParams = call.request.queryParameters.entries()
                .associate { it.key to it.value.first() }

            if (macroComponentName != null && macroComponentName in componentRegistry) {
                // Call the component function with query parameters
                val render = componentRegistry[macroComponentName]?.invoke(queryParams)

                // Respond with the rendered component
                call.respond(
                    HttpStatusCode.OK,
                    UiResponse(
                        message = "Success",
                        render = render ?: emptyList()
                    )
                )
            } else {
                // Handle invalid macroComponentName
                call.respond(
                    HttpStatusCode.BadRequest,
                    UiResponse(
                        message = "Invalid macro component name",
                        render = emptyList()
                    )
                )
            }
        }
    }
}