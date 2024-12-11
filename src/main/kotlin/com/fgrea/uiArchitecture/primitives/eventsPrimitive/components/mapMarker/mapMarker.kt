package com.fgrea.uiArchitecture

import com.fgrea.features.ui.model.*
import com.fgrea.features.ui.service.MapPoint

fun mapMarker(mapPoint: MapPoint): UIComponent {
    val iconManager = IconManager()
    val imageUrl = if(mapPoint.images.isNotEmpty()) "https://syrpoc.pockethost.io/" + "api/files/" + mapPoint.collectionId + "/" + mapPoint.id + "/" + mapPoint.images[0] else ""

    return UIComponent(
        type = "MapMarker",
        properties = mapOf(
            "key" to UIProperty.StringValue(mapPoint.id), 
            "longitude" to UIProperty.DoubleValue(mapPoint.longitude), 
            "latitude" to UIProperty.DoubleValue(mapPoint.latitude)
        ),
        children = listOf(
            UIComponent(
                type = "Container",
                properties = mapOf(
                    "contextTiedTo" to UIProperty.StringValue("SelectedId"),
                    "existValue" to UIProperty.MapValue(mapOf(
                        "include" to UIProperty.NumberValue(1),
                        "id" to UIProperty.StringValue(mapPoint.id)
                    ))
                ),
                children = listOf(
                    UIComponent(
                        type = "Button",
                        properties = mapOf(
                            "clickBehaviour" to UIProperty.StringValue("change_context"),
                            "clickContext" to UIProperty.StringValue("SelectedId"),
                            "newContextValue" to UIProperty.MapValue(mapOf(
                                "id" to UIProperty.StringValue(mapPoint.id)
                            )),
                            "className" to UIProperty.StringValue("w-[40px] h-[28px] flex items-center justify-center shadow-[0px_0px_4px_1px_#00000060] rounded-full bg-white [&>svg]:fill-black")
                        ),
                        children = listOf(
                            iconManager.getIcon(mapPoint.type, mapOf("className" to UIProperty.StringValue("w-[20px] h-[20px]")))
                        )
                    )
                )
            ),
            UIComponent(
                type = "Container",
                properties = mapOf(
                    "contextTiedTo" to UIProperty.StringValue("SelectedId"),
                    "existValue" to UIProperty.MapValue(mapOf(
                        "include" to UIProperty.NumberValue(0),
                        "id" to UIProperty.StringValue(mapPoint.id)
                    ))
                ),
                children = listOf(
                    UIComponent(
                        type = "Button",
                        properties = mapOf(
                            "clickBehaviour" to UIProperty.StringValue("change_context"),
                            "clickContext" to UIProperty.StringValue("SelectedId"),
                            "newContextValue" to UIProperty.MapValue(mapOf(
                                "id" to UIProperty.NumberValue(0)
                            )),
                            "className" to UIProperty.StringValue("w-[40px] h-[28px] flex items-center justify-center shadow-[0px_0px_4px_1px_#00000060] rounded-full bg-black [&>svg]:fill-white")
                        ),
                        children = listOf(
                            iconManager.getIcon(mapPoint.type, mapOf("className" to UIProperty.StringValue("w-[20px] h-[20px]")))
                        )
                    )
                )
            ),
            UIComponent(
                type = "MapPopup",
                properties = mapOf(
                    "latitude" to UIProperty.DoubleValue(mapPoint.latitude),
                    "longitude" to UIProperty.DoubleValue(mapPoint.longitude),
                    "id" to UIProperty.StringValue(mapPoint.id)
                ),
                children = listOf(
                    UIComponent(
                        type = "Container",
                        properties = mapOf("className" to UIProperty.StringValue("relative w-[500px] h-[160px] p-2 flex flex-row")),
                        children = listOf(
                            UIComponent(
                                type = "Button",
                                properties = mapOf(
                                    "clickBehaviour" to UIProperty.StringValue("change_context"),
                                    "clickContext" to UIProperty.StringValue("SelectedId"),
                                    "newContextValue" to UIProperty.MapValue(mapOf(
                                        "id" to UIProperty.NumberValue(0)
                                    )),
                                    "className" to UIProperty.StringValue("absolute top-4 left-4 flex items-center justify-center border-none rounded-full bg-white w-[28px] h-[28px] focus:outline-none shadow-[0_0_10px_0_rgba(0,0,0,0.1)]")
                                ),
                                children = listOf(
                                    iconManager.getIcon("xIcon", mapOf("className" to UIProperty.StringValue("w-[20px] h-[20px]")))
                                )
                            ),
                            UIComponent(
                                type = "Button",
                                properties = mapOf(
                                    "clickBehaviour" to UIProperty.StringValue("post_context"),
                                    "clickContext" to UIProperty.StringValue("eventsCard"),
                                    "urlName" to UIProperty.StringValue("/api/eventPicked"),
                                    "newContextValue" to UIProperty.MapValue(mapOf(
                                        "selectedId" to UIProperty.StringValue(mapPoint.id),
                                        "mainButton" to UIProperty.NumberValue(0)
                                    )),
                                    "className" to UIProperty.StringValue("w-full h-full grid grid-cols-9 grid-rows-4 text-start rounded-xl overflow-hidden bg-white shadow-[0px_0px_4px_1px_#00000050]")
                                ),
                                children = listOf(
                                    UIComponent(
                                        type = "Image",
                                        properties = mapOf(
                                            "src" to UIProperty.StringValue(imageUrl), 
                                            "width" to UIProperty.NumberValue(1500), 
                                            "height" to UIProperty.NumberValue(1500), 
                                            "alt" to UIProperty.StringValue(mapPoint.title), 
                                            "className" to UIProperty.StringValue("object-cover w-full h-full col-span-3 row-span-4 col-start-1 row-start-1")
                                        )
                                    ),
                                    UIComponent(
                                        type = "Text",
                                        properties = mapOf("text" to UIProperty.StringValue(mapPoint.title), "className" to UIProperty.StringValue("col-span-6 row-span-2 p-1 text-lg font-bold line-clamp-2 flex items-center"))
                                    ),
                                    UIComponent(
                                        type = "Container",
                                        properties = mapOf("className" to UIProperty.StringValue("flex flex-row col-span-4 row-start-3 col-start-4 p-1 items-center")),
                                        children = listOf(
                                            iconManager.getIcon("locationIcon", mapOf("className" to UIProperty.StringValue("w-[20px] h-[20px]"))),
                                            UIComponent(
                                                type = "Text",
                                                properties = mapOf(
                                                    "text" to UIProperty.StringValue(mapPoint.location), 
                                                    "className" to UIProperty.StringValue("font-bold text-base w-full truncate")
                                                )
                                            )
                                        )
                                    ),
                                    UIComponent(
                                        type = "Container",
                                        properties = mapOf("className" to UIProperty.StringValue("flex flex-row col-span-4 row-span-4 col-start-4 p-1 items-center")),
                                        children = listOf(
                                            iconManager.getIcon("calendarIcon", mapOf("className" to UIProperty.StringValue("w-[20px] h-[20px]"))),
                                            UIComponent(
                                                type = "Text",
                                                properties = mapOf("text" to UIProperty.StringValue(mapPoint.date), "className" to UIProperty.StringValue("font-bold text-base w-full truncate"))
                                            )
                                        )
                                    ),
                                    UIComponent(
                                        type = "Container",
                                        properties = mapOf("className" to UIProperty.StringValue("col-span-2 row-span-2 row-start-3 h-full p-1")),
                                        children = listOf(
                                            UIComponent(
                                                type = "Container",
                                                properties = mapOf("className" to UIProperty.StringValue("flex flex-col items-center justify-evenly w-full h-full rounded-xl text-base bg-black text-white")),
                                                children = listOf(
                                                    UIComponent(
                                                        type = "Container",
                                                        properties = mapOf("className" to UIProperty.StringValue("flex flex-row items-center justify-center gap-1")),
                                                        children = listOf(
                                                            UIComponent(
                                                                type = "Text",
                                                                properties = mapOf("text" to UIProperty.StringValue("3/4"), "className" to UIProperty.StringValue("font-bold text-base h-[20px]"))
                                                            ),
                                                            iconManager.getIcon("twoPeopleIcon", mapOf("className" to UIProperty.StringValue("w-[20px] h-[20px] invert")))
                                                        )
                                                    ),  
                                                    UIComponent(
                                                        type = "Text",
                                                        properties = mapOf("text" to UIProperty.StringValue("1000€"), "className" to UIProperty.StringValue("font-bold truncate w-fit"))
                                                    )
                                                )
                                            )
                                        )
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