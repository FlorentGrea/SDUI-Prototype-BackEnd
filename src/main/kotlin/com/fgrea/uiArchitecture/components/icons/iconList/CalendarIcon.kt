package com.fgrea.uiArchitecture.components.icons.iconList

import com.fgrea.features.ui.model.*

fun calendarIcon(additionalProps: Map<String, UIProperty> = mapOf()): UIComponent {
    return UIComponent(
        type = "Svg",
        properties = mapOf(
            "fill" to UIProperty.StringValue("#000000"),
            "width" to UIProperty.StringValue("800px"),
            "height" to UIProperty.StringValue("800px"),
            "viewBox" to UIProperty.StringValue("0 0 256 256"),
            "id" to UIProperty.StringValue("Flat"),
            "d" to UIProperty.StringValue("M208,28H188V20a12,12,0,0,0-24,0v8H92V20a12,12,0,0,0-24,0v8H48A20.02229,20.02229,0,0,0,28,48V208a20.02229,20.02229,0,0,0,20,20H208a20.02229,20.02229,0,0,0,20-20V48A20.02229,20.02229,0,0,0,208,28Zm-4,24V76H52V52ZM52,204V100H204V204Z")
        ) + additionalProps
    )
} 