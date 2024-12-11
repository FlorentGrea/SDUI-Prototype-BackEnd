package com.fgrea.uiArchitecture

import com.fgrea.features.ui.model.*

fun locationSearchBar(): UIComponent {  
    val iconManager = IconManager()
    
    return UIComponent(
        type = "Container",
        properties = mapOf("className" to UIProperty.StringValue("w-full h-fit flex flex-row items-center")),  
        children = listOf(
            UIComponent(
                type = "Container",
                properties = mapOf("className" to UIProperty.StringValue("w-full h-10 p-1 flex flex-row rounded-full items-center bg-[#eeeeee]")),
                children = listOf(
                    iconManager.getIcon("searchIcon", mapOf("className" to UIProperty.StringValue("w-[28px] h-[28px] fill-[#888888]"))),
                    UIComponent(
                        type = "Input",
                        properties = mapOf(
                            "context" to UIProperty.StringValue("ViewState"),
                            "placeholder" to UIProperty.StringValue("Localisation"),
                            "fetchUrl" to UIProperty.StringValue("/api/adressAutoComplete"),
                            "className" to UIProperty.StringValue("w-full h-full text-xl bg-transparent outline-none"),
                            "type" to UIProperty.StringValue("search"),
                        )
                    ),
                    UIComponent(
                        type = "Button",
                        properties = mapOf(
                            "clickBehaviour" to UIProperty.StringValue("change_context"),
                            "clickContext" to UIProperty.StringValue("eventFilters"),
                            "newContextValue" to UIProperty.MapValue(mapOf("filterClicked" to UIProperty.NumberValue(1))),
                        )
                    ),
                    iconManager.getIcon("filterIcon", mapOf("className" to UIProperty.StringValue("w-[40px] h-[40px]")))
                )
            )
        )
    )
}