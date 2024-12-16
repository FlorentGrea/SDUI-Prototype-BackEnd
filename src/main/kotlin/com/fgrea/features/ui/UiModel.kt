package com.fgrea.features.ui.model

import kotlinx.serialization.*

@Serializable
sealed class UIProperty {
    @Serializable
    @SerialName("string")
    data class StringValue(val value: String) : UIProperty()

    @Serializable
    @SerialName("number")
    data class NumberValue(val value: Int) : UIProperty()

    @Serializable
    @SerialName("map")
    data class MapValue(val value: Map<String, UIProperty>) : UIProperty()

    @Serializable
    @SerialName("list")
    data class ListValue(val value: List<Map<String, UIProperty>>) : UIProperty()
}

@Serializable
data class UIComponent(
    val type: String, // The type of the component (e.g., "button", "text")
    val properties: Map<String, UIProperty> = emptyMap(), // Dynamic properties
    val children: List<UIComponent> = emptyList() // Nested child components
)