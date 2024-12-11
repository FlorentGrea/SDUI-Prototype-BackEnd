package com.fgrea.features.uiArchitecture

import com.fgrea.features.ui.model.UIComponent
import com.fgrea.uiArchitecture.*
import com.fgrea.features.ui.service.MapPoint

sealed interface ComponentFactory {
    fun create(mapPoint: MapPoint? = null): UIComponent
}

class SimpleComponentFactory(private val factory: () -> UIComponent) : ComponentFactory {
    override fun create(mapPoint: MapPoint?): UIComponent = factory()
}

class MapPointComponentFactory(private val factory: (MapPoint) -> UIComponent) : ComponentFactory {
    override fun create(mapPoint: MapPoint?): UIComponent {
        requireNotNull(mapPoint) { "MapPoint is required for this component" }
        return factory(mapPoint)
    }
}

// Register all components
object ComponentRegistry {
    private val components: Map<String, ComponentFactory> = mapOf(
        "main" to SimpleComponentFactory { main() },
        "mapmarker" to MapPointComponentFactory { mapPoint -> mapMarker(mapPoint) },
        //"main" to MapPointComponentFactory { mapPoint -> main(mapPoint) },
        //"container" to SimpleComponentFactory { container() },
        //"button" to SimpleComponentFactory { button() }
        // Add more components here
    )

    fun getComponent(name: String, mapPoint: MapPoint? = null): UIComponent {
        println("Requested component: $name")
        return components[name.lowercase()]?.create(mapPoint) ?: throw IllegalArgumentException("Component not found: $name")
    }
}