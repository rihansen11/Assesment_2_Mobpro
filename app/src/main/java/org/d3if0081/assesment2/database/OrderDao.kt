package org.d3if0081.assesment2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if0081.assesment2.model.Order



@Dao
interface OrderDao {

    @Insert
    suspend fun insert(order: Order)

    @Update
    suspend fun update(order: Order)

//    @Query("SELECT * FROM `order` ORDER BY tanggal DESC")
    @Query("SELECT * FROM `order` ORDER BY nama ASC, jenisLaundry")
    fun getOrder(): Flow<List<Order>>

    @Query("SELECT * FROM `order` WHERE id = :id")
    suspend fun getOrderById(id: Long): Order?

    @Query("DELETE FROM `order` WHERE id = :id")
    suspend fun deleteById(id: Long)
}