package com.fgrea.ui.components.icons.iconList

fun listIcon(additionalProps: Map<String, String> = mapOf()): Map<String, Any> {
    return mapOf(
        "type" to "Svg",
        "props" to mapOf(
            "fill" to "#000000",
            "width" to "800px",
            "height" to "800px",
            "viewBox" to "0 0 256 256",
            "id" to "Flat",
            "d" to "M228,128.00037a12.00028,12.00028,0,0,1-12,12H40a12,12,0,0,1,0-24H216A12.00028,12.00028,0,0,1,228,128.00037Zm-188-52H216a12,12,0,0,0,0-24H40a12,12,0,1,0,0,24Zm176,104H40a12,12,0,0,0,0,24H216a12,12,0,0,0,0-24Z"
        ) + additionalProps
    )
} 