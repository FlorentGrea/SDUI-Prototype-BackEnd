package com.fgrea.uiArchitecture.components.icons.iconList

import com.fgrea.features.ui.model.*

fun twoPeopleIcon(additionalProps: Map<String, UIProperty> = mapOf()): UIComponent {
    return UIComponent(
        type = "Svg",
        properties = mapOf(
            "fill" to UIProperty.StringValue("#000000"),
            "width" to UIProperty.StringValue("800px"),
            "height" to UIProperty.StringValue("800px"),
            "viewBox" to UIProperty.StringValue("0 0 256 256"),
            "id" to UIProperty.StringValue("Flat"),
            "d" to UIProperty.StringValue("M129.20984,156.91406a64,64,0,1,0-82.41907-.00024A100.1807,100.1807,0,0,0,6.18408,190.48828a12,12,0,1,0,19.624,13.81641,76.01736,76.01736,0,0,1,124.38085-.0044,12.00012,12.00012,0,1,0,19.623-13.81836A100.17887,100.17887,0,0,0,129.20984,156.91406ZM48.00049,108a40,40,0,1,1,40,40A40.04552,40.04552,0,0,1,48.00049,108Z")
        ) + additionalProps
    )
} 