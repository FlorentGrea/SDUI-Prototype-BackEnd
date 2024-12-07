package com.fgrea.features.ui.UiModel

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

@Serializable
sealed class AnySerializable {
    @Serializable
    data class Primitive(val value: JsonPrimitive) : AnySerializable()

    @Serializable
    data class MapValue(val value: JsonObject) : AnySerializable()
}

@Serializable
data class UiComponent(
    val type: String,
    val props: Map<String, AnySerializable> = emptyMap(),
    val children: List<UiComponent> = emptyList()
)

@Serializable
data class UiResponse(
    val message: String,
    val render: List<UiComponent>
)