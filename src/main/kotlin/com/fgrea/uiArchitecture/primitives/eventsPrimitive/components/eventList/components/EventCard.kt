package com.fgrea.uiArchitecture

import com.fgrea.features.ui.model.*
import com.fgrea.features.ui.service.MapPoint
import kotlin.random.Random

fun eventCard(point: MapPoint): UIComponent {
    val iconManager = IconManager()
    val imageUrl = if(point.images.isNotEmpty()) "https://syrpoc.pockethost.io/" + "api/files/" + point.collectionId + "/" + point.id + "/" + point.images[0] else "/placeholder.webp"

    return UIComponent(
        type = "Button",
        properties = mapOf(
            "clickBehaviour" to UIProperty.StringValue("change_context"),
            "clickContext" to UIProperty.StringValue("eventsCard"),
            "newContextValue" to UIProperty.MapValue(mapOf(
                "selectedId" to UIProperty.StringValue(point.id),               
                "reRender" to UIProperty.StringValue("Random"),

            )),
            "className" to UIProperty.StringValue("relative flex flex-col w-full h-fit")
        ),
        children = listOf(
            UIComponent(
                type = "Container",
                properties = mapOf("className" to UIProperty.StringValue("absolute top-2 left-2 flex items-center justify-center w-[28px] h-[20px] rounded-full bg-white shadow-[0px_0px_4px_1px_#00000060]")),
                children = listOf(
                    iconManager.getIcon(point.type, mapOf("className" to UIProperty.StringValue("w-[16px] h-[16px]")))
                )
            ),
            UIComponent(
                type = "Image",
                properties = mapOf(
                    "src" to UIProperty.StringValue(imageUrl), 
                    "width" to UIProperty.NumberValue(1500), 
                    "height" to UIProperty.NumberValue(1500), 
                    "alt" to UIProperty.StringValue(""), 
                    "className" to UIProperty.StringValue("w-full h-[200px] object-cover rounded-[12px]")
                )
            ),
            UIComponent(
                type = "Text",
                properties = mapOf("text" to UIProperty.StringValue(point.title), "className" to UIProperty.StringValue("w-full my-[8px] h-fit font-bold text-[16px] text-left line-clamp-1"))
            ),
            UIComponent(
                type = "Container",
                properties = mapOf("className" to UIProperty.StringValue("w-full h-[40px] grid grid-cols-[3fr_1fr] grid-rows-[1fr_1fr]")),
                children = listOf(
                    UIComponent(
                        type = "Container",
                        properties = mapOf("className" to UIProperty.StringValue("flex flex-row gap-[4px] items-center col-start-1 row-start-1")),
                        children = listOf(
                            iconManager.getIcon("locationIcon", mapOf("className" to UIProperty.StringValue("w-[20px] h-[20px]"))), 
                            UIComponent(
                                type = "Text",
                                properties = mapOf("text" to UIProperty.StringValue(point.location), "className" to UIProperty.StringValue("font-bold text-[12px] line-clamp-1"))
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
                                properties = mapOf("text" to UIProperty.StringValue(point.date), "className" to UIProperty.StringValue("font-bold text-[12px] line-clamp"))
                            )
                        )
                    ),
                    UIComponent(
                        type = "Container",
                        properties = mapOf("className" to UIProperty.StringValue("w-full col-start-2 row-start-1 row-span-2")),
                        children = listOf(
                            UIComponent(
                                type = "Container", 
                                properties = mapOf("className" to UIProperty.StringValue("flex flex-col items-center justify-evenly w-full h-full rounded-xl text-[12px] bg-black text-white")), 
                                children = listOf(
                                    UIComponent(
                                        type = "Container", 
                                        properties = mapOf("className" to UIProperty.StringValue("flex flex-row items-center justify-center gap-1")), 
                                        children = listOf(
                                            UIComponent(
                                                type = "Text", 
                                                properties = mapOf("text" to UIProperty.StringValue("3/4"), "className" to UIProperty.StringValue("font-bold text-[12px] h-[20px]"))
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
            )
        )
    )
}