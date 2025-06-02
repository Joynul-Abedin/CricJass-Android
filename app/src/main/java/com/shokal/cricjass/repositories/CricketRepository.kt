package com.shokal.cricjass.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.shokal.cricjass.database.CricketDao
import com.shokal.cricjass.database.DataBase

class CricketRepository(context: Context) {
    private val db: CricketDao = DataBase.getDatabase(context).cricketDao()
    fun getAllCountries(): LiveData<List<com.shokal.cricjass.models.countries.Data>> {
        return db.getAllCountries()
    }

    fun getAllContinents(): LiveData<List<com.shokal.cricjass.models.continents.Data>> {
        return db.getAllContinents()
    }

    fun getAllTeams(): LiveData<List<com.shokal.cricjass.models.teams.Data>> {
        return db.getAllTeams()
    }

    fun getAllLeague(): LiveData<List<com.shokal.cricjass.models.leagues.Data>> {
        return db.getAllLeagues()
    }

    fun getAllTeamByCountryId(id: Int): LiveData<List<com.shokal.cricjass.models.teams.Data>> {
        return db.getALlTeamsWithCountryID(id)
    }

    fun getTeamName(id: Long): LiveData<String> {
        return db.getTeamName(id)
    }

    fun getLeagueName(id: Long): LiveData<String> {
        return db.getLeagueName(id)
    }

    fun getCountryName(id: Int): LiveData<String> {
        return db.getCountryName(id)
    }

    fun getImageFromTeam(id: Long): LiveData<String> {
        return db.getImageFromTeam(id)
    }

    suspend fun insertAllCountry(country: List<com.shokal.cricjass.models.countries.Data>) {
        return db.insertAllCountries(country)
    }

    suspend fun insertAllContinents(continent: List<com.shokal.cricjass.models.continents.Data>) {
        return db.insertAllContinents(continent)
    }

    suspend fun insertAllTeams(continent: List<com.shokal.cricjass.models.teams.Data>) {
        return db.insertAllTeams(continent)
    }

    suspend fun insertAllLeague(league: List<com.shokal.cricjass.models.leagues.Data>) {
        return db.insertAllLeagues(league)
    }
}