package com.fgrea.uiArchitecture

import com.fgrea.features.ui.model.*

fun eventsTypeFilter(): UIComponent {
    val iconManager = IconManager()

    return UIComponent(
        type = "Container",
        properties = mapOf("className" to UIProperty.StringValue("w-full h-fit p-2 gap-2 flex flex-col justify-center")),
        children = listOf(
            UIComponent(
                type = "Container", 
                properties = mapOf("className" to UIProperty.StringValue("w-full h-[1px] bg-[#00000020]"))
            ),
            UIComponent(
                type = "Container",
                properties = mapOf(
                    "contextTiedTo" to UIProperty.StringValue("eventFilters"),
                    "existValue" to UIProperty.MapValue(mapOf(
                        "include" to UIProperty.NumberValue(0),
                        "activityType" to UIProperty.NumberValue(0),
                    ))
                ),
                children = listOf(
                    UIComponent(
                        type = "Button",
                        properties = mapOf(
                            "clickBehaviour" to UIProperty.StringValue("change_context"),
                            "clickContext" to UIProperty.StringValue("eventFilters"),
                            "newContextValue" to UIProperty.MapValue(mapOf("activityType" to UIProperty.NumberValue(1))),
                            "className" to UIProperty.StringValue("w-full h-fit flex flex-row justify-between"),
                        ),
                        children = listOf(
                            UIComponent(
                                type = "Text",
                                properties = mapOf("text" to UIProperty.StringValue("Types d'activités"), "className" to UIProperty.StringValue("text-xl font-bold h-[28px] flex items-center"))
                            ),
                            iconManager.getIcon("downArrowIcon", mapOf("className" to UIProperty.StringValue("w-[28px] h-[28px]")))
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
                        "activityType" to UIProperty.NumberValue(1),
                    ))
                ),
                children = listOf(
                    UIComponent(
                        type = "Button",
                        properties = mapOf(
                            "clickBehaviour" to UIProperty.StringValue("change_context"),
                            "clickContext" to UIProperty.StringValue("eventFilters"),
                            "newContextValue" to UIProperty.MapValue(mapOf("activityType" to UIProperty.NumberValue(0))),
                            "className" to UIProperty.StringValue("w-full h-fit flex flex-row justify-between"),
                        ),
                        children = listOf(
                            UIComponent(
                                type = "Text",
                                properties = mapOf("text" to UIProperty.StringValue("Types d'activités"), "className" to UIProperty.StringValue("text-xl font-bold h-[28px] flex items-center"))
                            ),
                            iconManager.getIcon("upArrowIcon", mapOf("className" to UIProperty.StringValue("w-[28px] h-[28px]")))
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
                        "activityType" to UIProperty.NumberValue(1),
                    )),
                    "className" to UIProperty.StringValue("grid grid-cols-4 gap-2 justify-items-center")
                ),
                children = typeList()
            )
        )
    )
}