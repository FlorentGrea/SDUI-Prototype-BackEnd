package com.fgrea.uiArchitecture

import com.fgrea.features.ui.model.*

fun mapMenu(): UIComponent {

    return UIComponent(
        type = "Container",
        properties = mapOf("className" to UIProperty.StringValue("z-10 absolute left-0 top-0 right-0 m-auto mt-2 w-[400px] h-fit p-1 flex flex-col rounded-[24px] pointer-events-auto bg-white shadow-[0px_0px_4px_1px_#00000060]")),
        children = listOf(
            UIComponent(
                type = "Container",
                properties = mapOf(
                    "contextTiedTo" to UIProperty.StringValue("eventFilters"),
                    "existValue" to UIProperty.MapValue(mapOf(
                        "include" to UIProperty.NumberValue(0),
                        "filterClicked" to UIProperty.NumberValue(0),
                    ))
                ),
                children = listOf(
                    locationSearchBar(),
                    //UIComponent(
                    //    type = "SduiCall",
                    //    properties = mapOf(
                    //        "macroComponentName" to UIProperty.StringValue("AdressAutoComplete"),
                    //        "context" to UIProperty.StringValue("ViewState")
                    //    )
                    //)
                )
            ),
            filtersList()
        )
    )
}