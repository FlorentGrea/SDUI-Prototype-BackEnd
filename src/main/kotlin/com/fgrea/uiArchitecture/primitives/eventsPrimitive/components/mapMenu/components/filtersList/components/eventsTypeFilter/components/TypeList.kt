package com.fgrea.uiArchitecture

import com.fgrea.features.ui.model.*

fun typeList(): List<UIComponent> {
    val iconManager = IconManager()

    val typeList = listOf(
        "BicycleIcon" to "Bicycle Trip",
        "BedIcon" to "Coliving",
        "BoatIcon" to "Boat Trip",
        "VanIcon" to "Van Trip",
        "MeetIcon" to "Meeting"
    )

    val components = typeList.map { type ->
        UIComponent(
            type = "Container",
            properties = mapOf("className" to UIProperty.StringValue("w-full aspect-square")),
            children = listOf(
                UIComponent(
                    type = "Container",
                    properties = mapOf(
                        "contextTiedTo" to UIProperty.StringValue("eventFilters"),
                        "existValue" to UIProperty.MapValue(mapOf(
                            "include" to UIProperty.NumberValue(0),
                            type.first to UIProperty.NumberValue(1),
                        )),
                        "className" to UIProperty.StringValue("w-full aspect-square"),
                    ),
                    children = listOf(
                        UIComponent(
                            type = "Button",
                            properties = mapOf(
                                "clickBehaviour" to UIProperty.StringValue("change_context"),
                                "clickContext" to UIProperty.StringValue("eventFilters"),
                                "newContextValue" to UIProperty.MapValue(mapOf(type.first to UIProperty.NumberValue(0))),
                                "className" to UIProperty.StringValue("aspect-square w-full border-4 border-black rounded-lg font-bold flex flex-col items-center justify-center"),
                            ),
                            children = listOf(
                                iconManager.getIcon(type.first, mapOf("className" to UIProperty.StringValue("w-[28px] h-[28px]"))),
                                UIComponent(
                                    type = "Text",
                                    properties = mapOf("text" to UIProperty.StringValue(type.second), "className" to UIProperty.StringValue("text-center"))
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
                            type.first to UIProperty.NumberValue(0),
                        )),
                        "className" to UIProperty.StringValue("w-full aspect-square"),
                    ),
                    children = listOf(
                        UIComponent(
                            type = "Button",
                            properties = mapOf(
                                "clickBehaviour" to UIProperty.StringValue("change_context"),
                                "clickContext" to UIProperty.StringValue("eventFilters"),
                                "newContextValue" to UIProperty.MapValue(mapOf(type.first to UIProperty.NumberValue(1))),
                                "className" to UIProperty.StringValue("aspect-square w-full bg-black text-white rounded-lg font-bold flex flex-col items-center justify-center"),
                            ),
                            children = listOf(
                                iconManager.getIcon(type.first, mapOf("className" to UIProperty.StringValue("w-[28px] h-[28px] fill-white"))),
                                UIComponent(
                                    type = "Text",
                                    properties = mapOf("text" to UIProperty.StringValue(type.second), "className" to UIProperty.StringValue("text-center"))
                                )
                            )
                        )
                    )
                )
            )
        )
    }

    return components
}