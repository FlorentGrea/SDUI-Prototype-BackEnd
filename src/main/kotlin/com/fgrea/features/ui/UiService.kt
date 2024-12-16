package com.fgrea.features.ui.service

import com.fgrea.features.ui.model.*
import com.fgrea.features.uiArchitecture.ComponentRegistry

class UiService {
    fun getComponentByName(name: String): UIComponent? {
        return ComponentRegistry.getComponent(name)
    }
}