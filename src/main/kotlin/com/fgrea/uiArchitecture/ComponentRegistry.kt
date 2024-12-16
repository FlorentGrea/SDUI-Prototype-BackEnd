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
        "eventcard" to MapPointComponentFactory { mapPoint -> eventCard(mapPoint) },
        "eventdisplay" to MapPointComponentFactory { mapPoint -> eventDisplay(mapPoint) },
    )

    fun getComponent(name: String, mapPoint: MapPoint? = null): UIComponent {
        return components[name.lowercase()]?.create(mapPoint) ?: throw IllegalArgumentException("Component not found: $name")
    }
}