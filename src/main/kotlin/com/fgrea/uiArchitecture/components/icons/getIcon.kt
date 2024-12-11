package com.fgrea.uiArchitecture

import com.fgrea.uiArchitecture.components.icons.iconList.*
import com.fgrea.features.ui.model.*

class IconManager {
    private val functions = mapOf(
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

    fun getIcon(iconName: String, props: Map<String, UIProperty> = mapOf()): UIComponent {
        // Convert first letter to lowercase for function name matching
        val functionName = iconName.first().lowercase() + iconName.substring(1)
        
        return functions[functionName]?.let { it(props) } ?: throw IllegalArgumentException("Icon \"$iconName\" not found")
    }
}