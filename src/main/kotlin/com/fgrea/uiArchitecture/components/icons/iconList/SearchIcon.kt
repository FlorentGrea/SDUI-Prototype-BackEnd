package com.fgrea.uiArchitecture.components.icons.iconList

import com.fgrea.features.ui.model.*

fun searchIcon(additionalProps: Map<String, UIProperty> = mapOf()): UIComponent {
    return UIComponent(
        type = "Svg",
        properties = mapOf(
            "fill" to UIProperty.StringValue("#000000"),
            "width" to UIProperty.StringValue("800px"),
            "height" to UIProperty.StringValue("800px"),
            "viewBox" to UIProperty.StringValue("0 0 256.00098 256.00098"),
            "id" to UIProperty.StringValue("Flat"),
            "d" to UIProperty.StringValue("M232.47656,215.51563l-40.67773-40.67774a96.10791,96.10791,0,1,0-16.97168,16.96973l40.67871,40.67871a12.0001,12.0001,0,1,0,16.9707-16.9707ZM43.99707,116a72,72,0,1,1,72,72A72.08124,72.08124,0,0,1,43.99707,116Z")
        ) + additionalProps
    )
}