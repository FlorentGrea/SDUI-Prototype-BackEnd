package com.fgrea.uiArchitecture.components.icons.iconList

import com.fgrea.features.ui.model.*

fun vanIcon(additionalProps: Map<String, UIProperty> = mapOf()): UIComponent {
    return UIComponent(
        type = "Svg",
        properties = mapOf(
            "fill" to UIProperty.StringValue("#000000"),
            "width" to UIProperty.StringValue("800px"),
            "height" to UIProperty.StringValue("800px"),
            "viewBox" to UIProperty.StringValue("0 0 256 256"),
            "id" to UIProperty.StringValue("Flat"),
            "d" to UIProperty.StringValue("M240,112H228V88a20.02229,20.02229,0,0,0-20-20H164V56a20.02229,20.02229,0,0,0-20-20H48A20.02229,20.02229,0,0,0,28,56V168a20.02229,20.02229,0,0,0,20,20H64.42627a36.00088,36.00088,0,0,0,71.14746,0h48.85254a36.00088,36.00088,0,0,0,71.14746,0H240a12,12,0,0,0,12-12V124A12,12,0,0,0,240,112ZM52,92h88v24H52Zm18,108a12,12,0,1,1,12-12A12,12,0,0,1,70,200Zm60-36H81.57373a36.00088,36.00088,0,0,0-71.14746,0H48a4,4,0,0,1-4-4V140H144v20A4,4,0,0,1,130,164Zm30,36a12,12,0,1,1,12-12A12,12,0,0,1,190,200ZM228,164h-4.42627a36.00088,36.00088,0,0,0-71.14746,0H148V92h60a4,4,0,0,1,4,4v24H228Z")
        ) + additionalProps
    )
}