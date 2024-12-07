package com.fgrea.ui.components.icons

import com.fgrea.ui.components.icons.iconList.*

data class IconResult(
    val type: String,
    val props: Map<String, Any>
)

data class SvgProps(
    val additionalProps: Map<String, String> = mapOf()
)

class IconManager {
    private val functions: Map<String, (Map<String, String>) -> Map<String, Any>> = mapOf(
        "bedIcon" to ::bedIcon,
        "bicycleIcon" to ::bicycleIcon,
        "boatIcon" to ::boatIcon,
        "calendarIcon" to ::calendarIcon,
        "carIcon" to ::carIcon,
        "chatIcon" to ::chatIcon,
        "downArrowIcon" to ::downArrowIcon,
        "filterIcon" to ::filterIcon,
        "houseIcon" to ::houseIcon,
        "leftArrowIcon" to ::leftArrowIcon,
        "listIcon" to ::listIcon,
        "locateIcon" to ::locateIcon,
        "locationIcon" to ::locationIcon,
        "mapIcon" to ::mapIcon,
        "meetIcon" to ::meetIcon,
        "planeIcon" to ::planeIcon,
        "plusIcon" to ::plusIcon,
        "positionIcon" to ::positionIcon,
        "rightArrowIcon" to ::rightArrowIcon,
        "searchIcon" to ::searchIcon,
        "twoPeopleIcon" to ::twoPeopleIcon,
        "upArrowIcon" to ::upArrowIcon,
        "uploadIcon" to ::uploadIcon,
        "vanIcon" to ::vanIcon,
        "warningIcon" to ::warningIcon,
        "xIcon" to ::xIcon
    )

    fun getIcon(iconName: String, props: Map<String, String> = mapOf()): IconResult {
        // Convert first letter to lowercase for function name matching
        val functionName = iconName.first().lowercase() + iconName.substring(1)
        
        return functions[functionName]?.let { function ->
            IconResult(
                type = "Svg",
                props = function(props)
            )
        } ?: throw IllegalArgumentException("Icon \"$iconName\" not found")
    }
}