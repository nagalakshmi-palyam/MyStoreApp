package com.lakshmi.myapplication.ProfileRoomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lakshmi.myapplication.RoomDatabse.Products

@Dao
interface StoreProfileDao {
    @Insert
    suspend fun insertImageandType(storeProfileandImage: StoreProfileandImage)
    @Query("Select * From storeimage")
    fun getImageandType(): LiveData<List<StoreProfileandImage>>
}