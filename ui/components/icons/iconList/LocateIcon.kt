package com.fgrea.ui.components.icons.iconList

fun locateIcon(additionalProps: Map<String, String> = mapOf()): Map<String, Any> {
    return mapOf(
        "type" to "Svg",
        "props" to mapOf(
            "width" to "24",
            "height" to "24",
            "viewBox" to "0 0 24 24",
            "fill" to "none",
            "stroke" to "currentColor",
            "strokeWidth" to "2",
            "strokeLinecap" to "round",
            "strokeLinejoin" to "round",
            "d" to "M2 12h3 M19 12h3 M12 2v3 M12 19v3 M12 19a7 7 0 1 0 0-14 7 7 0 0 0 0 14"
        ) + additionalProps
    )
} 