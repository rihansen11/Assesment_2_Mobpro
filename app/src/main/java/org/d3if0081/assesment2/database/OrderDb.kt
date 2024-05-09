package org.d3if0081.assesment2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if0081.assesment2.model.Order

@Database(entities = [Order::class], version = 1, exportSchema = false)
abstract class OrderDb : RoomDatabase() {
    abstract val dao: OrderDao

    companion object {
        @Volatile
        private var INSTANCE: OrderDb? = null
        fun getInstance(context: Context) : OrderDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        OrderDb::class.java,
                        "order.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}