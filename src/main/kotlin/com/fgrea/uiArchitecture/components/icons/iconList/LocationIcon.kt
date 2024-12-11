package com.fgrea.uiArchitecture.components.icons.iconList

import com.fgrea.features.ui.model.*

fun locationIcon(additionalProps: Map<String, UIProperty> = mapOf()): UIComponent {
    return UIComponent(
        type = "Svg",
        properties = mapOf(
            "fill" to UIProperty.StringValue("#000000"),
            "width" to UIProperty.StringValue("800px"),
            "height" to UIProperty.StringValue("800px"),
            "viewBox" to UIProperty.StringValue("0 0 256 256"),
            "id" to UIProperty.StringValue("Flat"),
            "d" to UIProperty.StringValue("M199.99975,220H160.73437c5.17652-4.97607,10.74146-10.70947,16.321-17.126,28.09472-32.30859,42.94433-66.499,42.94433-98.874a92,92,0,0,0-184,0c0,50.01221,34.11963,91.94238,59.18408,116H55.99975a12,12,0,0,0,0,24h144a12,12,0,0,0,0-24Zm-140-116a68,68,0,0,1,136,0c0,33.31055-19.95605,63.36621-36.69824,82.71387a249.0586,249.0586,0,0,1-31.30176,30.17138A249.0053,249.0053,0,0,1,96.698,186.71387C79.95581,167.36621,59.99975,137.31055,59.99975,104Zm68,44a44,44,0,1,0-44-44A44.04978,44.04978,0,0,0,127.99975,148Zm0-64a20,20,0,1,1-20,20A20.02229,20.02229,0,0,1,127.99975,84Z")
        ) + additionalProps
    )
} 