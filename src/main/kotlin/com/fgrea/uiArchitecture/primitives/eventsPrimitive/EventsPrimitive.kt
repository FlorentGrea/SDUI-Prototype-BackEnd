package com.fgrea.uiArchitecture

import com.fgrea.features.ui.model.*
import kotlin.random.Random

fun eventsPrimitive(): UIComponent {
    return UIComponent(
        type = "Container",
        properties = mapOf(
            "contexts" to UIProperty.ListValue(listOf(
                mapOf(
                    "contextName" to UIProperty.StringValue("ViewState"),
                    "contextValue" to UIProperty.MapValue(mapOf(
                        "latitude" to UIProperty.DoubleValue(46.2276),
                        "longitude" to UIProperty.DoubleValue(2.2137),
                        "zoom" to UIProperty.NumberValue(4),
                        "reRender" to UIProperty.StringValue("Random"),
                    ))
                ),
                mapOf(
                    "contextName" to UIProperty.StringValue("SelectedId"),
                    "contextValue" to UIProperty.MapValue(mapOf(
                        "id" to UIProperty.NumberValue(0),
                    ))
                ),
                mapOf(
                    "contextName" to UIProperty.StringValue("eventFilters"),
                    "contextValue" to UIProperty.MapValue(mapOf(
                        "activityType" to UIProperty.NumberValue(0),
                        "BedIcon" to UIProperty.NumberValue(0),
                        "BicycleIcon" to UIProperty.NumberValue(0),
                        "BoatIcon" to UIProperty.NumberValue(0),
                        "CarIcon" to UIProperty.NumberValue(0),
                        "MeetIcon" to UIProperty.NumberValue(0),
                        "PlaneIcon" to UIProperty.NumberValue(0),
                        "VanIcon" to UIProperty.NumberValue(0),
                        "filterClicked" to UIProperty.NumberValue(0),   
                        "reRender" to UIProperty.StringValue("Random"),

                    ))
                ),
                mapOf(
                    "contextName" to UIProperty.StringValue("eventsCard"),
                    "contextValue" to UIProperty.MapValue(mapOf(
                        "mainButton" to UIProperty.NumberValue(1),
                        "selectedId" to UIProperty.StringValue(""),
                    ))
                ),
            )),
            "className" to UIProperty.StringValue("w-full h-screen"),
        ),
        children = listOf(
            UIComponent(
                type = "Map",
                children = listOf(
                    UIComponent(
                        type = "Container",
                        properties = mapOf("className" to UIProperty.StringValue("w-full h-full")),
                        children = listOf(
                            UIComponent(
                                type = "SduiCall",
                                properties = mapOf(
                                    "urlName" to UIProperty.StringValue("mapmarker?db=events&action=getFiltered&filters="), 
                                    "context" to UIProperty.StringValue("eventFilters"),
                                    "urlValue" to UIProperty.StringValue("all")
                                )
                            ),
                            mapMenu(),
                            //UIComponent(
                            //    type = "SduiCall",
                            //    props = mapOf("urlName" to "MapMenu")
                            //),
                            eventList(),
                            //UIComponent(
                            //    type = "SduiCall",
                            //    props = mapOf("urlName" to "eventList")
                            //)
                        )
                    )
                )
            )
        )
    )
}