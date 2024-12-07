package com.fgrea.ui.components.icons.iconList

fun upArrowIcon(additionalProps: Map<String, String> = mapOf()): Map<String, Any> {
    return mapOf(
        "type" to "Svg",
        "props" to mapOf(
            "fill" to "#000000",
            "width" to "800px",
            "height" to "800px",
            "viewBox" to "0 0 256 256",
            "id" to "Flat",
            "d" to "M208,172a11.96187,11.96187,0,0,1-8.48535-3.51465L128,96.9707,56.48535,168.48535a12.0001,12.0001,0,0,1-16.9707-16.9707l80-80a11.99975,11.99975,0,0,1,16.9707,0l80,80A12,12,0,0,1,208,172Z"
        ) + additionalProps
    )
} 