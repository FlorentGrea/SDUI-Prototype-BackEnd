package com.fgrea.uiArchitecture.components.icons.iconList

import com.fgrea.features.ui.model.*

fun listIcon(additionalProps: Map<String, UIProperty> = mapOf()): UIComponent {
    return UIComponent(
        type = "Svg",
        properties = mapOf(
            "fill" to UIProperty.StringValue("#000000"),
            "width" to UIProperty.StringValue("800px"),
            "height" to UIProperty.StringValue("800px"),
            "viewBox" to UIProperty.StringValue("0 0 256 256"),
            "id" to UIProperty.StringValue("Flat"),
            "d" to UIProperty.StringValue("M228,128.00037a12.00028,12.00028,0,0,1-12,12H40a12,12,0,0,1,0-24H216A12.00028,12.00028,0,0,1,228,128.00037Zm-188-52H216a12,12,0,0,0,0-24H40a12,12,0,1,0,0,24Zm176,104H40a12,12,0,0,0,0,24H216a12,12,0,0,0,0-24Z")
        ) + additionalProps
    )
} 