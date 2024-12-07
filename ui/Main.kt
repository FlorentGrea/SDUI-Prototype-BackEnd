package com.fgrea.ui

fun mainPage(): Map<String, Any> {
    return arrayOf(
        mapOf(
            "type" to "Container",  
            "props" to mapOf(
                "contexts" to arrayOf(
                    mapOf(
                        "contextName" to "Primitives",
                        "contextValue" to mapOf(
                            "settingsPrimitive" to 0,
                            "eventPrimitive" to 1,
                            "messagesPrimitive" to 0,
                        )
                    )
                ),
                "className" to "w-full h-screen"
            ),
            "children" to arrayOf(
                mapOf(
                    "type" to "SduiCall",
                    "props" to mapOf("macroComponentName" to "EventPrimitive")
                ),
                mapOf(
                    "type" to "SduiCall",
                    "props" to mapOf("macroComponentName" to "MainMenu")
                )
            )
        )
    )
}