package com.fgrea.uiArchitecture.components.icons.iconList

import com.fgrea.features.ui.model.*

fun bicycleIcon(additionalProps: Map<String, UIProperty> = mapOf()): UIComponent {
    return UIComponent(
        type = "Svg",
        properties = mapOf(
            "fill" to UIProperty.StringValue("#000000"),
            "width" to UIProperty.StringValue("800px"),
            "height" to UIProperty.StringValue("800px"),
            "viewBox" to UIProperty.StringValue("0 0 256 256"),
            "id" to UIProperty.StringValue("Flat"),
            "d" to UIProperty.StringValue("M204,108a51.822,51.822,0,0,0-15.12769,2.251L168.89258,76H192a4.00427,4.00427,0,0,1,4,4,12,12,0,0,0,24,0,28.03146,28.03146,0,0,0-28-28H148a12.00033,12.00033,0,0,0-10.36523,18.04639L145.77441,84H109.55884L94.36523,57.95361A12.00042,12.00042,0,0,0,84,52H52a12,12,0,0,0,0,24H77.10742L88.17505,94.97314,73.98853,112.89307a52.14733,52.14733,0,1,0,18.80273,14.91455l8.36987-10.57251,16.80664,28.81128a11.99987,11.99987,0,1,0,20.73047-12.09278L123.55859,108h36.21582l8.38648,14.37695A51.95955,51.95955,0,1,0,204,108ZM80,160a28.02724,28.02724,0,1,1-21.709-27.27856L42.5918,152.55176a11.9996,11.9996,0,1,0,18.8164,14.89648L77.106,147.62012A27.82432,27.82432,0,0,1,80,160Zm124,28a27.9829,27.9829,0,0,1-23.10522-43.7937l12.74,21.84009a11.99987,11.99987,0,1,0,20.73046-12.09278l-12.74316-21.84546C202.40674,132.04175,203.19849,132,204,132a28,28,0,0,1,0,56Z")
        ) + additionalProps
    )
}