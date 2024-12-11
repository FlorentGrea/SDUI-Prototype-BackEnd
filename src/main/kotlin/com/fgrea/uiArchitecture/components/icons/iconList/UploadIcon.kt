package com.fgrea.uiArchitecture.components.icons.iconList

import com.fgrea.features.ui.model.*

fun uploadIcon(additionalProps: Map<String, UIProperty> = mapOf()): UIComponent {
    return UIComponent(
        type = "Svg",
        properties = mapOf(
            "fill" to UIProperty.StringValue("#000000"),
            "width" to UIProperty.StringValue("800px"),
            "height" to UIProperty.StringValue("800px"),
            "viewBox" to UIProperty.StringValue("0 0 256 256"),
            "id" to UIProperty.StringValue("Flat"),
            "d" to UIProperty.StringValue("M123.99219,144.00586,124,203.99805a12,12,0,0,1-24,.0039l-.00415-31.02783L48.45654,224.51367a12.0001,12.0001,0,1,1-16.9707-16.9707L83.025,156.00391,51.99854,156A12,12,0,0,1,52,132h.00146l59.99219.00781A11.99987,11.99987,0,0,1,123.99219,144.00586ZM208,28H72A20.0226,20.0226,0,0,0,52,48V92a12,12,0,0,0,24,0V52H204V204H156a12,12,0,0,0,0,24h52a20.0226,20.0226,0,0,0,20-20V48A20.0226,20.0226,0,0,0,208,28Z")
        ) + additionalProps
    )
} 