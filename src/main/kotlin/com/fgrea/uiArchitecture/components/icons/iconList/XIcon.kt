package com.fgrea.uiArchitecture.components.icons.iconList

import com.fgrea.features.ui.model.*

fun xIcon(additionalProps: Map<String, UIProperty> = mapOf()): UIComponent {
    return UIComponent(
        type = "Svg",
        properties = mapOf(
            "fill" to UIProperty.StringValue("#000000"),
            "width" to UIProperty.StringValue("800px"),
            "height" to UIProperty.StringValue("800px"),
            "viewBox" to UIProperty.StringValue("0 0 256 256"),
            "id" to UIProperty.StringValue("Flat"),
            "d" to UIProperty.StringValue("M205.65674,194.34326a11.99911,11.99911,0,0,1-16.9707,0L128,133.65723,67.31348,194.34326a11.99911,11.99911,0,0,1-16.9707,0,11.99911,11.99911,0,0,1,0-16.9707L111.02979,116.686,50.34326,56.00049a11.99911,11.99911,0,0,1,16.9707-16.9707L128,99.71533l60.68652-60.68554a11.99911,11.99911,0,0,1,16.9707,16.9707L144.97021,116.686l60.68653,60.68652A11.99911,11.99911,0,0,1,205.65674,194.34326Z")
        ) + additionalProps
    )
} 