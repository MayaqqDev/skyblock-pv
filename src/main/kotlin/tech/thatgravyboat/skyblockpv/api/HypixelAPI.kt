package tech.thatgravyboat.skyblockpv.api

import com.google.gson.JsonObject
import tech.thatgravyboat.skyblockapi.utils.http.Http

// TODO switch to some other api :3
private const val API_URL = "https://api.hypixel.net/%s"
private const val API_KEY = "c68c34ea-83eb-442f-9505-0bdccb0d7f20"

object HypixelAPI {

    suspend fun get(endpoint: String, params: Map<String, String>): JsonObject? {
        return Http.getResult<JsonObject>(
            url = API_URL.format(endpoint),
            queries = params,
            headers = mapOf("API-Key" to API_KEY)
        ).map { it.takeIf { it.get("success")?.asBoolean == true } }.getOrNull()
    }
}
