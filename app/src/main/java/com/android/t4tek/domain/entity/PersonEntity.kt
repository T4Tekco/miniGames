package com.android.t4tek.domain.entity

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.t4tek.domain.json_model.JsonPerson

@Keep
@Entity(tableName = "Person")
class PersonEntity{
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    @ColumnInfo(name = "name")
    var name: String? = ""

    @ColumnInfo(name = "craft", defaultValue = "ISS")
    var craft: String? = ""
    override fun toString(): String {
        return "PersonEntity(id=$id, name=$name, craft=$craft)"
    }

}