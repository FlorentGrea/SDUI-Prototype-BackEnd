package com.fgrea.uiArchitecture

import com.fgrea.features.ui.model.*

fun filtersList(): UIComponent {

    return UIComponent(
        type = "Container",
        properties = mapOf(
            "contextTiedTo" to UIProperty.StringValue("eventFilters"),
            "existValue" to UIProperty.MapValue(mapOf(
                "include" to UIProperty.NumberValue(0),
                "filterClicked" to UIProperty.NumberValue(1),
            ))
        ),
        children = listOf(
            UIComponent(
                type = "Container",
                properties = mapOf(
                    "className" to UIProperty.StringValue("w-full h-fit flex flex-row items-center justify-center"),
                ),
                children = listOf(
                    UIComponent(
                        type = "Text",
                        properties = mapOf(
                            "text" to UIProperty.StringValue("Filtres"),
                            "className" to UIProperty.StringValue("text-xl font-bold h-10 flex items-center"),
                        )
                    ),
                    UIComponent(
                        type = "Container",
                        properties = mapOf(
                            "className" to UIProperty.StringValue("w-full h-[600px] rounded-xl shadow-[inset_0px_-4px_10px_0px_#00000020] overflow-y-scroll scrollbar-hide"),
                        ),  
                        children = listOf(
                            eventsTypeFilter(),
                        )
                    )
                )
            ),
            UIComponent(
                type = "Container",
                properties = mapOf(
                    "className" to UIProperty.StringValue("w-full h-fit p-1 pt-2 flex flex-row justify-evenly"),
                ),
                children = listOf(
                    UIComponent(
                        type = "Button",
                        properties = mapOf(
                            "clickBehaviour" to UIProperty.StringValue("post_context"),
                            "urlName" to UIProperty.StringValue("/api/filters"),
                            "clickContext" to UIProperty.StringValue("eventFilters"),
                            "newContextValue" to UIProperty.MapValue(mapOf(
                                "BedIcon" to UIProperty.NumberValue(0),
                                "BicycleIcon" to UIProperty.NumberValue(0),
                                "BoatIcon" to UIProperty.NumberValue(0),
                                "CarIcon" to UIProperty.NumberValue(0),
                                "MeetIcon" to UIProperty.NumberValue(0),
                                "PlaneIcon" to UIProperty.NumberValue(0),
                                "VanIcon" to UIProperty.NumberValue(0),
                                "filterClicked" to UIProperty.NumberValue(0),
                            )),
                            "className" to UIProperty.StringValue("w-[100px] h-10 text-xl font-bold"),
                        ),
                        children = listOf(
                            UIComponent(
                                type = "Text",
                                properties = mapOf("text" to UIProperty.StringValue("Effacer"))
                            )
                        )
                    ),
                    UIComponent(
                        type = "Button",
                        properties = mapOf(
                            "clickBehaviour" to UIProperty.StringValue("post_context"),
                            "urlName" to UIProperty.StringValue("/api/filters"),
                            "clickContext" to UIProperty.StringValue("eventFilters"),
                            "newContextValue" to UIProperty.MapValue(mapOf(
                                "filterClicked" to UIProperty.NumberValue(0),
                            )),
                            "className" to UIProperty.StringValue("w-[100px] h-10 bg-[#000000] text-white text-xl font-bold rounded-full"),
                        ),
                        children = listOf(
                            UIComponent(
                                type = "Text",
                                properties = mapOf("text" to UIProperty.StringValue("Filtrer"))
                            )
                        )
                    )
                )
            )
        )
    )
}