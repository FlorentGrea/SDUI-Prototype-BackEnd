package com.fgrea.uiArchitecture

import com.fgrea.features.ui.model.*

fun eventList(): UIComponent {
    val iconManager = IconManager()

    return UIComponent(
        type = "Container",
        properties = mapOf("className" to UIProperty.StringValue("z-10 absolute bottom-[60px] right-[60px]")),
        children = listOf(
            UIComponent(
                type = "Container",
                properties = mapOf(
                    "contextTiedTo" to UIProperty.StringValue("eventsCard"),
                    "existValue" to UIProperty.MapValue(mapOf(
                        "include" to UIProperty.NumberValue(0), 
                        "mainButton" to UIProperty.NumberValue(1)
                    )),
                ),
                children = listOf(
                    UIComponent(
                        type = "Button",
                        properties = mapOf(
                            "clickBehaviour" to UIProperty.StringValue("change_context"),
                            "clickContext" to UIProperty.StringValue("eventsCard"),
                            "newContextValue" to UIProperty.MapValue(mapOf("mainButton" to UIProperty.NumberValue(0))),
                            "className" to UIProperty.StringValue("w-[100px] h-[60px] flex items-center justify-center bg-white rounded-[12px] shadow-[0px_0px_4px_1px_#00000020]")
                        ),
                        children = listOf(
                            UIComponent(
                                type = "Text",
                                properties = mapOf(
                                    "text" to UIProperty.StringValue("Activités"),
                                    "className" to UIProperty.StringValue("text-lg text-center font-bold")
                                )
                            )
                        )
                    )
                )
            ),
            UIComponent(
                type = "Container",
                properties = mapOf(
                    "contextTiedTo" to UIProperty.StringValue("eventsCard"),
                    "existValue" to UIProperty.MapValue(mapOf(
                        "include" to UIProperty.NumberValue(0), 
                        "mainButton" to UIProperty.NumberValue(0)
                    )),
                    "className" to UIProperty.StringValue("w-[650px] h-[calc(100vh-120px)] px-2 pb-2 pt-1 flex flex-col items-center bg-white rounded-[12px] shadow-[0px_0px_4px_1px_#00000020]")
                ),
                children = listOf(
                    UIComponent(
                        type = "Container",
                        properties = mapOf(
                            "contextTiedTo" to UIProperty.StringValue("eventsCard"),
                            "existValue" to UIProperty.MapValue(mapOf(
                                "include" to UIProperty.NumberValue(0), 
                                "selectedId" to UIProperty.StringValue("")
                            )),
                            "className" to UIProperty.StringValue("w-full h-fit mb-1 flex items-center justify-center"),
                        ),
                        children = listOf(
                            UIComponent(
                                type = "Container",
                                properties = mapOf("className" to UIProperty.StringValue("w-[20px] h-[20px]"))
                            ),
                            UIComponent(
                                type = "Text",
                                properties = mapOf("text" to UIProperty.StringValue("Activités"), "className" to UIProperty.StringValue("font-bold text-center text-lg flex-grow"))
                            ),
                            UIComponent(
                                type = "Button",
                                properties = mapOf(
                                    "clickBehaviour" to UIProperty.StringValue("change_context"),
                                    "clickContext" to UIProperty.StringValue("eventsCard"),
                                    "newContextValue" to UIProperty.MapValue(mapOf(
                                        "mainButton" to UIProperty.NumberValue(1), 
                                        "selectedId" to UIProperty.StringValue("")
                                    ))
                                ),
                                children = listOf(
                                    iconManager.getIcon("xIcon", mapOf("className" to UIProperty.StringValue("w-[28px] h-[28px]")))
                                )
                            )
                        )
                    ),
                    UIComponent(
                        type = "Container",
                        properties = mapOf(
                            "contextTiedTo" to UIProperty.StringValue("eventsCard"),
                            "existValue" to UIProperty.MapValue(mapOf(
                                "include" to UIProperty.NumberValue(0), 
                                "selectedId" to UIProperty.StringValue("")
                            )),
                            "className" to UIProperty.StringValue("w-full h-full rounded-[12px] shadow-[inset_0px_-4px_10px_0px_rgba(0,_0,_0,_0.2)] overflow-hidden"),
                        ),
                        children = listOf(
                            UIComponent(
                                type = "Container",
                                properties = mapOf("className" to UIProperty.StringValue("w-full h-full pr-3 overflow-y-auto grid grid-cols-2 gap-[12px] p-[12px] [&::-webkit-scrollbar]:w-2 [&::-webkit-scrollbar-track]:bg-transparent [&::-webkit-scrollbar-thumb]:bg-gray-300 [&::-webkit-scrollbar-thumb]:rounded-full hover:[&::-webkit-scrollbar-thumb]:bg-gray-400 [&::-webkit-scrollbar]:ml-1")),
                                children = listOf(
                                    UIComponent(
                                        type = "SduiCall",
                                        properties = mapOf(
                                            "urlName" to UIProperty.StringValue("eventCard?db=events&action=getFiltered&filters="), 
                                            "context" to UIProperty.StringValue("eventFilters"),
                                            "urlValue" to UIProperty.StringValue("all")
                                        )
                                    )
                                )
                            )
                        )
                    ),
                    UIComponent(
                        type = "SduiCall",
                        properties = mapOf(
                            "urlName" to UIProperty.StringValue("eventdisplay?db=events&action=getOne&id="), 
                            "context" to UIProperty.StringValue("eventsCard"),
                            "urlValue" to UIProperty.StringValue("selectedId")
                        )
                    )
                )
            )
        )
    )
}