package com.fgrea.uiArchitecture

import com.fgrea.features.ui.model.*
import com.fgrea.features.ui.service.MapPoint

fun eventDisplay(mapPoint: MapPoint): UIComponent {
    val iconManager = IconManager()
    val imageUrl = if (mapPoint.images.isNotEmpty() && mapPoint.images[0] != "") {
        "https://syrpoc.pockethost.io/api/files/${mapPoint.collectionId}/${mapPoint.id}/${mapPoint.images[0]}"
    } else {
        "/placeholder.webp"
    }

    return UIComponent(
        type = "Container",
        properties = mapOf(
            "contextTiedTo" to UIProperty.StringValue("eventsCard"),
            "existValue" to UIProperty.MapValue(mapOf(
                "include" to UIProperty.NumberValue(0),
                "selectedId" to UIProperty.StringValue(mapPoint.id)
            )),
            "className" to UIProperty.StringValue("mt-1 p-1 flex flex-col gap-[8px] w-full h-full")
        ),
        children = listOf(
            UIComponent(
                type = "Container",
                properties = mapOf("className" to UIProperty.StringValue("absolute top-[20px] left-[20px] w-[40px] h-[28px] flex items-center justify-center bg-white rounded-full shadow-[0_0_10px_0_rgba(0,0,0,0.1)]")),
                children = listOf(
                    iconManager.getIcon(mapPoint.type, mapOf("className" to UIProperty.StringValue("w-[20px] h-[20px]")))
                )
            ),
            UIComponent(
                type = "Button",
                properties = mapOf(
                    "clickBehaviour" to UIProperty.StringValue("change_context"),
                    "clickContext" to UIProperty.StringValue("eventsCard"),
                    "newContextValue" to UIProperty.MapValue(mapOf(
                        "selectedId" to UIProperty.StringValue("")
                    )),
                    "className" to UIProperty.StringValue("absolute top-[20px] right-[20px] w-[28px] h-[28px] flex items-center justify-center bg-white rounded-full shadow-[0_0_10px_0_rgba(0,0,0,0.1)]")
                ),
                children = listOf(
                    iconManager.getIcon("xIcon", mapOf("className" to UIProperty.StringValue("w-[20px] h-[20px]")))
                )
            ),
            UIComponent(
                type = "Image",
                properties = mapOf(
                    "src" to UIProperty.StringValue(imageUrl), 
                    "width" to UIProperty.NumberValue(1500), 
                    "height" to UIProperty.NumberValue(1500), 
                    "alt" to UIProperty.StringValue(""), 
                    "className" to UIProperty.StringValue("w-full h-[300px] object-cover rounded-[12px]")
                )
            ),
            UIComponent(
                type = "Text",
                properties = mapOf(
                    "text" to UIProperty.StringValue(mapPoint.title), 
                    "className" to UIProperty.StringValue("w-full h-[28px] font-bold text-[20px] text-left line-clamp-1 flex items-center")
                )
            ),
            UIComponent(
                type = "Container",
                properties = mapOf("className" to UIProperty.StringValue("w-full h-[60px] grid grid-cols-[3fr_1fr] grid-rows-[1fr_1fr]")),
                children = listOf(
                    UIComponent(
                        type = "Container",
                        properties = mapOf("className" to UIProperty.StringValue("flex flex-row gap-[4px] items-center col-start-1 row-start-1")),
                        children = listOf(
                            iconManager.getIcon("locationIcon", mapOf("className" to UIProperty.StringValue("w-[20px] h-[20px]"))), 
                            UIComponent(
                                type = "Text",
                                properties = mapOf("text" to UIProperty.StringValue(mapPoint.location), "className" to UIProperty.StringValue("font-bold text-[16px] line-clamp-1"))
                            )
                        )
                    ),
                    UIComponent(
                        type = "Container",
                        properties = mapOf("className" to UIProperty.StringValue("flex flex-row gap-[4px] items-center col-start-1 row-start-2")),
                        children = listOf(
                            iconManager.getIcon("calendarIcon", mapOf("className" to UIProperty.StringValue("w-[20px] h-[20px]"))), 
                            UIComponent(
                                type = "Text",
                                properties = mapOf("text" to UIProperty.StringValue(mapPoint.date), "className" to UIProperty.StringValue("font-bold text-[16px] line-clamp"))
                            )
                        )
                    ),
                    UIComponent(
                        type = "Container",
                        properties = mapOf("className" to UIProperty.StringValue("w-full col-start-2 row-start-1 row-span-2")),
                        children = listOf(
                            UIComponent(
                                type = "Container", 
                                properties = mapOf("className" to UIProperty.StringValue("flex flex-col items-center justify-evenly w-full h-full rounded-xl text-[16px] bg-black text-white")), 
                                children = listOf(
                                    UIComponent(
                                        type = "Container", 
                                        properties = mapOf("className" to UIProperty.StringValue("flex flex-row items-center justify-center gap-1")), 
                                        children = listOf(
                                            UIComponent(
                                                type = "Text", 
                                                properties = mapOf("text" to UIProperty.StringValue("3/4"), "className" to UIProperty.StringValue("font-bold text-[16px] h-[20px]"))
                                            ), 
                                            iconManager.getIcon("twoPeopleIcon", mapOf("className" to UIProperty.StringValue("w-[20px] h-[20px] invert")))
                                        )
                                    ),
                                    UIComponent(
                                        type = "Text", 
                                        properties = mapOf("text" to UIProperty.StringValue("1000€"), "className" to UIProperty.StringValue("font-bold line-clamp w-fit"))
                                    )
                                )
                            )
                        )
                    )
                )
            ),
            UIComponent(
                type = "Container",
                properties = mapOf("className" to UIProperty.StringValue("w-full h-[60px] flex flex-row gap-[4px] items-center")),
                children = listOf(
                    UIComponent(
                        type = "Image",
                        properties = mapOf(
                            "src" to UIProperty.StringValue(imageUrl), 
                            "width" to UIProperty.NumberValue(1500), 
                            "height" to UIProperty.NumberValue(1500), 
                            "alt" to UIProperty.StringValue(""), 
                            "className" to UIProperty.StringValue("w-[60px] h-[60px] object-cover rounded-full")
                        )
                    ),
                    UIComponent(
                        type = "Container",
                        properties = mapOf("className" to UIProperty.StringValue("h-full flex flex-col justify-evenly")),
                        children = listOf(
                            UIComponent(
                                type = "Text",
                                properties = mapOf("text" to UIProperty.StringValue("Kevin Cosmon"), "className" to UIProperty.StringValue("font-bold text-[16px] line-clamp-1"))
                            ),
                            UIComponent(
                                type = "Text",
                                properties = mapOf("text" to UIProperty.StringValue("29 ans - Français"), "className" to UIProperty.StringValue("font-bold text-[16px] line-clamp-1"))
                            )
                        )
                    )
                )
            ),
            UIComponent(
                type = "Text",
                properties = mapOf("text" to UIProperty.StringValue(mapPoint.description), "className" to UIProperty.StringValue("h-fit text-[16px]"))
            )
        )
    )
}