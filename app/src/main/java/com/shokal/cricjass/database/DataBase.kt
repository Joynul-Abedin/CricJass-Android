package com.shokal.cricjass.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        com.shokal.cricjass.models.countries.Data::class,
        com.shokal.cricjass.models.continents.Data::class,
        com.shokal.cricjass.models.teams.Data::class,
        com.shokal.cricjass.models.leagues.Data::class,
    ], version = 9
)
abstract class DataBase : RoomDatabase() {
    abstract fun cricketDao(): CricketDao

    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null
        fun getDatabase(context: Context): DataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, DataBase::class.java, "cricket_db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}