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
                val eventsApiUrl = "https://syrpoc.pockethost.io/api/collections/MapPoints/records"

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
                    println("getFiltered")
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