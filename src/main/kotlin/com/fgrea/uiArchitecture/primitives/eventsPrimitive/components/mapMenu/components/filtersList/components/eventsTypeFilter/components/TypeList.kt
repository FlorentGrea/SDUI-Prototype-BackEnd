package com.fgrea.uiArchitecture

import com.fgrea.features.ui.model.*

fun typeList(): UIComponent {
    val iconManager = IconManager()

    return UIComponent(
        type = "Container",
        properties = mapOf("className" to UIProperty.StringValue("w-full aspect-square")),
        children = listOf(
            UIComponent(
                type = "Container",
                properties = mapOf(
                    "contextTiedTo" to UIProperty.StringValue("eventFilters"),
                    "existValue" to UIProperty.MapValue(mapOf(
                        "include" to UIProperty.NumberValue(0),
                        "typebuttontochange" to UIProperty.NumberValue(1),
                    )),
                    "className" to UIProperty.StringValue("w-full aspect-square"),
                ),
                children = listOf(
                    UIComponent(
                        type = "Button",
                        properties = mapOf(
                            "clickBehaviour" to UIProperty.StringValue("change_context"),
                            "clickContext" to UIProperty.StringValue("eventFilters"),
                            "newContextValue" to UIProperty.MapValue(mapOf("typebuttontochange" to UIProperty.NumberValue(0))),
                            "className" to UIProperty.StringValue("aspect-square w-full border-4 border-black rounded-lg font-bold flex flex-col items-center justify-center"),
                        ),
                        children = listOf(
                            iconManager.getIcon("typeIcon", mapOf("className" to UIProperty.StringValue("w-[28px] h-[28px]"))),
                            UIComponent(
                                type = "Text",
                                properties = mapOf("text" to UIProperty.StringValue("typebuttontochange"), "className" to UIProperty.StringValue("text-center"))
                            )
                        )
                    )
                )
            ),
            UIComponent(
                type = "Container",
                properties = mapOf(
                    "contextTiedTo" to UIProperty.StringValue("eventFilters"),
                    "existValue" to UIProperty.MapValue(mapOf(
                        "include" to UIProperty.NumberValue(0),
                        "type" to UIProperty.NumberValue(0),
                    )),
                    "className" to UIProperty.StringValue("w-full aspect-square"),
                ),
                children = listOf(
                    UIComponent(
                        type = "Button",
                        properties = mapOf(
                            "clickBehaviour" to UIProperty.StringValue("change_context"),
                            "clickContext" to UIProperty.StringValue("eventFilters"),
                            "newContextValue" to UIProperty.MapValue(mapOf("type" to UIProperty.NumberValue(1))),
                            "className" to UIProperty.StringValue("aspect-square w-full bg-black text-white rounded-lg font-bold flex flex-col items-center justify-center"),
                        ),
                        children = listOf(
                            iconManager.getIcon("typeIcon", mapOf("className" to UIProperty.StringValue("w-[28px] h-[28px] fill-white"))),
                            UIComponent(
                                type = "Text",
                                properties = mapOf("text" to UIProperty.StringValue("typebuttontochange"), "className" to UIProperty.StringValue("text-center"))
                            )
                        )
                    )
                )
            )
        )
    )
}