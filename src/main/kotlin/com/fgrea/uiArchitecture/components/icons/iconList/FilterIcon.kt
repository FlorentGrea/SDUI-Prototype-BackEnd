package com.fgrea.uiArchitecture.components.icons.iconList

import com.fgrea.features.ui.model.*

fun filterIcon(additionalProps: Map<String, UIProperty> = mapOf()): UIComponent {
    return UIComponent(
        type = "Svg",
        properties = mapOf(
            "fill" to UIProperty.StringValue("#000000"),
            "width" to UIProperty.StringValue("800px"),
            "height" to UIProperty.StringValue("800px"),
            "viewBox" to UIProperty.StringValue("0 0 256 256"),
            "id" to UIProperty.StringValue("Flat"),
            "d" to UIProperty.StringValue("M227.99951,171.99353a12.00028,12.00028,0,0,1-12,12H197.65625a31.98806,31.98806,0,0,1-59.31348,0H39.99951a12,12,0,0,1,0-24h98.34326a31.98806,31.98806,0,0,1,59.31348,0h18.34326A12.00028,12.00028,0,0,1,227.99951,171.99353ZM39.999,95.99255l34.34375.00074a31.988,31.988,0,0,0,59.31348.00024L216,95.99255a12,12,0,0,0-.001-24l-82.34277.001a31.98813,31.98813,0,0,0-59.31348-.00024L40,71.99255h-.00049a12,12,0,0,0-.00049,24Z")
        ) + additionalProps
    )
} 