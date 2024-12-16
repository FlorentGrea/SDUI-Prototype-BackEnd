package com.fgrea.uiArchitecture

import com.fgrea.features.ui.model.*

fun mainMenu(params: Map<String, UIProperty> = mapOf()): UIComponent {
    val iconManager = IconManager()

    return UIComponent(
        type = "Container",
        properties = mapOf(
            "className" to UIProperty.StringValue("absolute bottom-0 left-0 flex flex-col w-[100vw] h-[100vh] justify-end items-center pointer-events-none")
        ),
        children = listOf(
            UIComponent(
                type = "Container",
                properties = mapOf("className" to UIProperty.StringValue("flex flex-col w-full md:w-[400px] shadow-[0px_0px_4px_1px_#00000020] p-1 md:p-2 gap-1 h-fit md:rounded-t-[12px] bg-white justify-end items-center pointer-events-auto")),
                children = listOf(
                    UIComponent(
                        type = "Container",
                        properties = mapOf("className" to UIProperty.StringValue("flex md:hidden m-auto h-[1px] w-full bg-gray-300")),
                    ),
                    UIComponent(
                        type = "Container",
                        properties = mapOf(
                            "className" to UIProperty.StringValue("flex justify-evenly w-full h-fit pointer-events-auto")
                        ),
                        children = listOf(
                            iconManager.getIcon("listIcon", mapOf("className" to UIProperty.StringValue("w-[28px] h-[28px] min-[400px]:w-[40px] min-[400px]:h-[40px]"))),
                            iconManager.getIcon("mapIcon", mapOf("className" to UIProperty.StringValue("w-[28px] h-[28px] min-[400px]:w-[40px] min-[400px]:h-[40px]"))),
                            iconManager.getIcon("chatIcon", mapOf("className" to UIProperty.StringValue("w-[28px] h-[28px] min-[400px]:w-[40px] min-[400px]:h-[40px]")))
                        )
                    )
                )
            )
        )
    )
}