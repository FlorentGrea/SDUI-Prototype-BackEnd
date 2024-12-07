package com.fgrea.ui.components.icons.iconList

fun bedIcon(additionalProps: Map<String, String> = mapOf()): Map<String, Any> {
    return mapOf(
        "type" to "Svg",
        "props" to mapOf(
            "fill" to "#000000",
            "width" to "800px",
            "height" to "800px",
            "viewBox" to "0 0 256 256",
            "id" to "Flat",
            "d" to "M208,68H28V48A12,12,0,0,0,4,48V208a12,12,0,0,0,24,0V180H228v28a12,12,0,0,0,24,0V112A44.04978,44.04978,0,0,0,208,68ZM28,92H92v64H28Zm88,64V92h92a20.02292,20.02292,0,0,1,20,20v44Z"
        ) + additionalProps
    )
} 