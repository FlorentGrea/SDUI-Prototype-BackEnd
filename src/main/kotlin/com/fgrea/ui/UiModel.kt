package com.fgrea.features.ui.model

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*

@Serializable(with = UIPropertySerializer::class)
sealed class UIProperty {
    data class StringValue(val value: String = "") : UIProperty()
    data class NumberValue(val value: Int = 0) : UIProperty()
    data class DoubleValue(val value: Double = 0.0) : UIProperty()
    data class MapValue(val value: Map<String, UIProperty> = emptyMap()) : UIProperty()
    data class ListValue(val value: List<Map<String, UIProperty>> = emptyList()) : UIProperty()
}

object UIPropertySerializer : KSerializer<UIProperty> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("UIProperty") {
        element<String>("type", isOptional = true)
        element<JsonElement>("value", isOptional = true)
    }

    override fun serialize(encoder: Encoder, value: UIProperty) {
        val jsonEncoder = encoder as? JsonEncoder ?: throw SerializationException("Expected JsonEncoder")
        val jsonElement = when (value) {
            is UIProperty.StringValue -> JsonPrimitive(value.value)
            is UIProperty.NumberValue -> JsonPrimitive(value.value)
            is UIProperty.DoubleValue -> JsonPrimitive(value.value)
            is UIProperty.MapValue -> JsonObject(value.value.mapValues { Json.encodeToJsonElement(it.value) })
            is UIProperty.ListValue -> JsonArray(value.value.map { JsonObject(it.mapValues { Json.encodeToJsonElement(it.value) }) })
        }
        jsonEncoder.encodeJsonElement(jsonElement)
    }

    override fun deserialize(decoder: Decoder): UIProperty {
        throw SerializationException("Deserialization is not supported")
    }
}

@Serializable
data class UIComponent(
    val type: String,
    val properties: Map<String, UIProperty> = emptyMap(),
    val children: List<UIComponent> = emptyList()
)