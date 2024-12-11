package com.fgrea.uiArchitecture.components.icons.iconList

import com.fgrea.features.ui.model.*

fun warningIcon(additionalProps: Map<String, UIProperty> = mapOf()): UIComponent {
    return UIComponent(
        type = "Svg",
        properties = mapOf(
            "fill" to UIProperty.StringValue("#000000"),
            "width" to UIProperty.StringValue("800px"),
            "height" to UIProperty.StringValue("800px"),
            "viewBox" to UIProperty.StringValue("0 0 256 256"),
            "id" to UIProperty.StringValue("Flat"),
            "d" to UIProperty.StringValue("M236.02637,208a7.99981,7.99981,0,0,1-6.92871,12H26.90234a7.99981,7.99981,0,0,1-6.92871-12L122.97363,44a8,8,0,0,1,13.85742,0ZM120,80v80a8,8,0,0,0,16,0V80a8,8,0,0,0-16,0Zm8,120a12,12,0,1,0-12-12A12,12,0,0,0,128,200Z")
        ) + additionalProps
    )
} 