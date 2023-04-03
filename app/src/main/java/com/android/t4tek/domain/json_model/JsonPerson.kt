package com.android.t4tek.domain.json_model

import androidx.annotation.Keep
import com.android.t4tek.domain.entity.PersonEntity
import com.squareup.moshi.Json

@Keep
data class JsonPerson(
    @Json(name = "name") val name: String,
    @Json(name = "craft") val craft: String
) {
    fun toEntity():PersonEntity{
        val personEntity = PersonEntity()
        personEntity.name = name
        personEntity.craft = craft
        return personEntity
    }
}