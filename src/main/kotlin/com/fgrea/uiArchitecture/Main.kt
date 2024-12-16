package com.fgrea.uiArchitecture

import com.fgrea.features.ui.model.*

fun main(): UIComponent {
    return UIComponent(
        type = "Container",  
        properties = mapOf(
            "contexts" to UIProperty.ListValue(listOf(
                mapOf(
                    "contextName" to UIProperty.StringValue("Primitives"),
                    "contextValue" to UIProperty.MapValue(mapOf(
                        "settingsPrimitive" to UIProperty.NumberValue(0),
                        "eventPrimitive" to UIProperty.NumberValue(1),
                        "messagesPrimitive" to UIProperty.NumberValue(0),
                    ))
                )
            )),
            "className" to UIProperty.StringValue("w-full h-screen")
        ),
        children = listOf(
            //UIComponent(
            //    type = "SduiCall",
            //    properties = mapOf("macroComponentName" to "EventPrimitive")
            //),
            mainMenu(),
            //UIComponent(
            //    type = "SduiCall",
            //    properties = mapOf("macroComponentName" to "MainMenu")
            //)
        )
    )
}