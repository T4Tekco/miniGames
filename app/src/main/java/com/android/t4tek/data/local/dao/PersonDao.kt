package com.android.t4tek.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.android.t4tek.domain.entity.PersonEntity

@Dao
interface PersonDao {
    @Query("SELECT * FROM Person")
    fun getAll(): List<PersonEntity>

    @Query("SELECT * FROM Person WHERE id IN (:ids)")
    fun loadAllByIds(ids: IntArray): List<PersonEntity>

    @Insert
    fun insertAll(vararg persons: PersonEntity)

    @Delete
    fun delete(entity: PersonEntity)

    @Query("DELETE FROM Person")
    fun clearAll()
}