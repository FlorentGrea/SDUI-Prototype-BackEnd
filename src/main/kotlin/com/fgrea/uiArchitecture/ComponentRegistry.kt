package com.fgrea.features.uiArchitecture

import com.fgrea.features.ui.model.UIComponent
import com.fgrea.uiArchitecture.*

// Register all components
object ComponentRegistry {    
    private val components: Map<String, () -> UIComponent> = mapOf(
        "main" to ::main
    )

    fun getComponent(name: String): UIComponent = components[name.lowercase()]?.invoke() ?: throw IllegalArgumentException("Component not found: $name")
}