package com.fgrea.uiArchitecture.components.icons.iconList

import com.fgrea.features.ui.model.*

fun xIcon(additionalProps: Map<String, UIProperty> = mapOf()): UIComponent {
    return UIComponent(
        type = "Svg",
        properties = mapOf(
            "width" to UIProperty.StringValue("24"),
            "height" to UIProperty.StringValue("24"),
            "viewBox" to UIProperty.StringValue("0 0 24 24"),
            "fill" to UIProperty.StringValue("#000000"),
            "stroke" to UIProperty.StringValue("#000000"),
            "strokeWidth" to UIProperty.StringValue("2"),
            "strokeLinecap" to UIProperty.StringValue("round"),
            "strokeLinejoin" to UIProperty.StringValue("round"),
            "d" to UIProperty.StringValue("M18 6 L6 18 M6 6 L18 18")
        ) + additionalProps
    )
}