package com.fgrea.uiArchitecture.components.icons.iconList

import com.fgrea.features.ui.model.*

fun locateIcon(additionalProps: Map<String, UIProperty> = mapOf()): UIComponent {
    return UIComponent(
        type = "Svg",
        properties = mapOf(
            "width" to UIProperty.StringValue("24"),
            "height" to UIProperty.StringValue("24"),
            "viewBox" to UIProperty.StringValue("0 0 24 24"),
            "fill" to UIProperty.StringValue("none"),
            "stroke" to UIProperty.StringValue("currentColor"),
            "strokeWidth" to UIProperty.StringValue("2"),
            "strokeLinecap" to UIProperty.StringValue("round"),
            "strokeLinejoin" to UIProperty.StringValue("round"),
            "d" to UIProperty.StringValue("M2 12h3 M19 12h3 M12 2v3 M12 19v3 M12 19a7 7 0 1 0 0-14 7 7 0 0 0 0 14")
        ) + additionalProps
    )
} 