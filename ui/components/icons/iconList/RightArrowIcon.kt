package com.fgrea.ui.components.icons.iconList

fun rightArrowIcon(additionalProps: Map<String, String> = mapOf()): Map<String, Any> {
    return mapOf(
        "type" to "Svg",
        "props" to mapOf(
            "fill" to "#000000",
            "width" to "800px",
            "height" to "800px",
            "viewBox" to "0 0 256 256",
            "id" to "Flat",
            "d" to "M96,220a12,12,0,0,1-8.48535-20.48535L159.0293,128,87.51465,56.48535a12.0001,12.0001,0,0,1,16.9707-16.9707l80,80a12.00062,12.00062,0,0,1,0,16.9707l-80,80A11.96287,11.96287,0,0,1,96,220Z"
        ) + additionalProps
    )
} 