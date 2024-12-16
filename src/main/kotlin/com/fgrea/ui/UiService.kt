package com.fgrea.features.ui.service

import com.fgrea.features.ui.model.*
import com.fgrea.features.uiArchitecture.ComponentRegistry
import com.fgrea.features.ui.Queries
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import io.ktor.client.call.*

@Serializable
data class MapPoint(
    val id: String,
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val updated: String,
    val title: String,
    val description: String,
    val latitude: Double,
    val longitude: Double,
    val type: String,
    val arrivalLocation: String,
    val date: String,
    val duration: String,
    val endDate: String,
    val endLatitude: Double,
    val endLongitude: Double,
    val images: List<String>,
    val location: String,
)

@Serializable
data class PocketBaseListResponse(
    val page: Int,
    val perPage: Int,
    val totalItems: Int,
    val totalPages: Int,
    val items: List<MapPoint>
)

class UiService {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
        expectSuccess = true
    }

    fun getComponentByName(name: String, queries: Queries): List<UIComponent> {
        println("Received queries: $queries")
        
        return try {
            if (queries["db"] == "events") {
                println("Handling events database query")
                var eventsApiUrl = "https://syrpoc.pockethost.io/api/collections/MapPoints/records"

                if (queries["action"] == "getAll") {
                    println("Fetching all events")
                    return runBlocking {
                        try {
                            val response = client.get(eventsApiUrl)
                            val mapPoints = response.body<PocketBaseListResponse>()
                            println("Received ${mapPoints.totalItems} map points")
                            
                            // Create a list of components from map points
                            mapPoints.items.map { point ->
                                ComponentRegistry.getComponent(name, point)
                            }
                        } catch (e: Exception) {
                            println("Error fetching events: ${e.message}")
                            emptyList()
                        }
                    }
                }

                if (queries["action"] == "getOne") {
                    if (queries["id"] != null) {

                        if (queries["id"] == "") {
                            println("ID is null or empty, creating emptyMapPoint")
                            val emptyMapPoint = MapPoint(
                                id = "noid",
                                collectionId = "nocollectionId",
                                collectionName = "nocollectionName",
                                created = "nocreated",
                                updated = "noupdated",
                                title = "notitle",
                                description = "nodescription",
                                latitude = 1.0,
                                longitude = 1.0,
                                type = "vanIcon",
                                arrivalLocation = "noarrivalLocation",
                                date = "nodate",
                                duration = "noduration",
                                endDate = "noendDate",
                                endLatitude = 1.0,
                                endLongitude = 1.0,
                                images = listOf(""),
                                location = "nolocation"
                            )
                            return runBlocking { listOf(ComponentRegistry.getComponent(name, emptyMapPoint)) }
                        }

                        return runBlocking {
                            try {
                                val response = client.get(eventsApiUrl + "/" + queries["id"])
                                val mapPoint = response.body<MapPoint>()
                                println("Received point: ${mapPoint.title} at (${mapPoint.latitude}, ${mapPoint.longitude})")
                                listOf(ComponentRegistry.getComponent(name, mapPoint))
                            } catch (e: Exception) {
                                println("Error fetching events: ${e.message}")
                                emptyList()
                            }
                        }
                    }
                }

                if (queries["action"] == "getFiltered") {

                    if (queries["filters"] != null) {
                        // Parse JSON string to Map
                        val jsonString = queries["filters"] as String
                        val filtersMap = kotlinx.serialization.json.Json.decodeFromString<Map<String, kotlinx.serialization.json.JsonElement>>(jsonString)
                        
                        val excludedTypes = filtersMap.entries.filter { entry -> 
                            when (val value = entry.value) {
                                is kotlinx.serialization.json.JsonPrimitive -> {
                                    value.toString() == "0" || value.toString() == "0.0"
                                }
                                else -> false
                            }
                        }.map {
                            entry -> entry.key 
                        }.filter { it != "filterClicked" && it != "reRender" }
                            
                        if (excludedTypes.isNotEmpty()) {
                            // Build the filter string
                            val filterQuery = excludedTypes.joinToString("||") { type -> "type='$type'" }
                            eventsApiUrl = "$eventsApiUrl?filter=$filterQuery"
                        }
                    }

                    return runBlocking {
                        try {
                            val response = client.get(eventsApiUrl)
                            val mapPoints = response.body<PocketBaseListResponse>()
                            println("Received ${mapPoints.totalItems} map points")
                            
                            // Create a list of components from map points
                            mapPoints.items.map { point ->
                                ComponentRegistry.getComponent(name, point)
                            }
                        } catch (e: Exception) {
                            println("Error fetching events: ${e.message}")
                            emptyList()
                        }
                    }
                }

                listOf(ComponentRegistry.getComponent(name))
            } else {
                listOf(ComponentRegistry.getComponent(name))
            }
        } catch (e: IllegalArgumentException) {
            emptyList()
        }
    }
}