package com.fgrea.ui.components.icons.iconList

fun positionIcon(additionalProps: Map<String, String> = mapOf()): Map<String, Any> {
    return mapOf(
        "type" to "Svg",
        "props" to mapOf(
            "fill" to "#000000",
            "width" to "800px",
            "height" to "800px",
            "viewBox" to "0 0 256 256",
            "id" to "Flat",
            "d" to "M236,116h-8.72266A100.19438,100.19438,0,0,0,140,28.72266V20a12,12,0,0,0-24,0v8.72266A100.19438,100.19438,0,0,0,28.72266,116H20a12,12,0,0,0,0,24h8.72266A100.19438,100.19438,0,0,0,116,227.27734V236a12,12,0,0,0,24,0v-8.72266A100.19438,100.19438,0,0,0,227.27734,140H236a12,12,0,0,0,0-24ZM128,204a76,76,0,1,1,76-76A76.08614,76.08614,0,0,1,128,204Z"
        ) + additionalProps
    )
} 