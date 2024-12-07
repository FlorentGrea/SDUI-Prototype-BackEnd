package com.fgrea.ui.primitives.events

fun eventPrimitive() {

    return arrayOf(
        mapOf(
            "type" to "Container",
            "props" to mapOf(
                "contexts" to arrayOf(
                    mapOf(
                        "contextName" to "ViewState",
                        "contextValue" to mapOf(
                            "latitude" to 46.2276,
                            "longitude" to 2.2137,
                            "zoom" to 4,
                            "reRender" to 1,
                        )
                    ),
                    mapOf(
                        "contextName" to "SelectedId",
                        "contextValue" to mapOf("id" to 0)
                    ),
                    mapOf(
                        "contextName" to "eventFilters",
                        "contextValue" to mapOf(
                            "activityType" to 0, //need to work if not declared
                            "BedIcon" to 0, //need to work if not declared
                            "BicycleIcon" to 0, //need to work if not declared
                            "BoatIcon" to 0, //need to work if not declared
                            "CarIcon" to 0, //need to work if not declared
                            "MeetIcon" to 0, //need to work if not declared
                            "PlaneIcon" to 0, //need to work if not declared
                            "VanIcon" to 0, //need to work if not declared
                            "filterClicked" to 0, //need to work if not declared
                            "reRender" to 1, //need to work if not declared
                        )
                    ),
                    mapOf(
                        "contextName" to "eventsCard",
                        "contextValue" to mapOf(
                            "mainButton" to 1,
                            "selectedId" to ""
                        )
                    )
                ),
                "className" to "w-full h-screen"
            ),
            "children" to arrayOf(
                mapOf(
                    "type" to "Map",
                    "children" to arrayOf(
                        mapOf(
                            "type" to "Container",
                            "props" to mapOf("className" to "w-full h-full"),
                            "children" to arrayOf(
                                mapOf(
                                    "type" to "SduiCall",
                                    "props" to mapOf(
                                        "query" to "eventFilters",
                                        "macroComponentName" to "MapMarkers",
                                        "context" to "eventFilters"
                                    )
                                ),
                                mapOf(
                                    "type" to "SduiCall",
                                    "props" to mapOf("macroComponentName" to "MapMenu")
                                ),
                                mapOf(
                                    "type" to "SduiCall",
                                    "props" to mapOf("macroComponentName" to "EventsCard")
                                )
                            )
                        )
                    )
                )
            )
        )
    )
}