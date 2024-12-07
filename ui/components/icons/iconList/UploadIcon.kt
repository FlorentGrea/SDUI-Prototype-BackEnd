package com.fgrea.ui.components.icons.iconList

fun uploadIcon(additionalProps: Map<String, String> = mapOf()): Map<String, Any> {
    return mapOf(
        "type" to "Svg",
        "props" to mapOf(
            "fill" to "#000000",
            "width" to "800px",
            "height" to "800px",
            "viewBox" to "0 0 256 256",
            "id" to "Flat",
            "d" to "M123.99219,144.00586,124,203.99805a12,12,0,0,1-24,.0039l-.00415-31.02783L48.45654,224.51367a12.0001,12.0001,0,1,1-16.9707-16.9707L83.025,156.00391,51.99854,156A12,12,0,0,1,52,132h.00146l59.99219.00781A11.99987,11.99987,0,0,1,123.99219,144.00586ZM208,28H72A20.0226,20.0226,0,0,0,52,48V92a12,12,0,0,0,24,0V52H204V204H156a12,12,0,0,0,0,24h52a20.0226,20.0226,0,0,0,20-20V48A20.0226,20.0226,0,0,0,208,28Z"
        ) + additionalProps
    )
} 