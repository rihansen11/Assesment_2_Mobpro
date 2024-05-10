package org.d3if0081.assesment2.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "order")
data class Order(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val kiloan: String,
    val jenisLaundry: String
//    val tanggal: String
)