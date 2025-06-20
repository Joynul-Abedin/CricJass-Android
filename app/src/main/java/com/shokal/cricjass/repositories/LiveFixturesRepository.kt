package com.shokal.cricjass.repositories

import android.util.Log
import com.shokal.cricjass.models.fixtures.Data
import com.shokal.cricjass.models.fixtures.Fixture
import com.shokal.cricjass.services.CricketAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "FixturesRepository"

class LiveFixturesRepository {
    var cache = listOf<Data>()
    fun getLiveFixtures(
        include: String, api_token: String, callback: (List<Data>) -> Unit
    ) {
        CricketAPI.retrofitService.getLiveFixtures(include, api_token)
            .enqueue(object : Callback<Fixture> {
                override fun onResponse(call: Call<Fixture>, response: Response<Fixture>) {
                    if (response.isSuccessful) {
                        val fixture = response.body()
                        if (fixture != null) {
                            val dataList = fixture.data
                            cache = dataList
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