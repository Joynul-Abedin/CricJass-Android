package com.shokal.cricjass.repositories

import android.util.Log
import com.shokal.cricjass.models.fixtures.Data
import com.shokal.cricjass.models.fixtures.Fixture
import com.shokal.cricjass.services.CricketAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "FixturesWithTeamReposit"

class FixturesWithTeamRepository {
    var flag = false
    val cache = HashMap<String, List<Data>>()
    fun getFixturesWithTeamId(
        leagueId: Int,
        date: String,
        include: String,
        sort: String,
        api_token: String,
        callback: (List<Data>) -> Unit
    ) {
        if (cache.containsKey(leagueId.toString())) {
            val list = cache[leagueId.toString()]
            getData(leagueId, date, include, sort, api_token, callback)

            cache[leagueId.toString()]?.map {
                if (list != null) {
                    Log.d(TAG, "getFixtures: ")
                    flag = !list.contains(it)
                }
            }
            if (flag) {
                Log.d(TAG, "$flag")
                callback(cache[leagueId.toString()]!!)
            } else {
                callback(list!!)
            }
        } else {
            getData(leagueId, date, include, sort, api_token, callback)
        }
    }

    private fun getData(
        leagueId: Int,
        date: String,
        include: String,
        sort: String,
        api_token: String,
        callback: (List<Data>) -> Unit
    ) {
        CricketAPI.retrofitService.getFixtureByTeamId(leagueId, date, include, sort, api_token)
            .enqueue(object : Callback<Fixture> {
                override fun onResponse(call: Call<Fixture>, response: Response<Fixture>) {
                    if (response.isSuccessful) {
                        val fixture = response.body()
                        if (fixture != null) {
                            val dataList = fixture.data
                            cache[leagueId.toString()] = dataList
                            callback(dataList)
                        }
                    }
                }

                override fun onFailure(call: Call<Fixture>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                }
            })

    }
}