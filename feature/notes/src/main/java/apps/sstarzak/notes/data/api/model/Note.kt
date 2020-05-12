package apps.sstarzak.notes.data.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Note(
    @Json(name = "content")
    val content: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String
)