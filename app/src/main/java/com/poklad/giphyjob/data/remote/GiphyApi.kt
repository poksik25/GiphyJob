package com.poklad.giphyjob.data.remote

import com.poklad.giphyjob.data.remote.model.GiphyResponse
import com.poklad.giphyjob.utlis.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApi {
    @GET(ApiConstants.TRENDING_GIFS)
    suspend fun getTrendingGifs(
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 0,
        @Query("rating") rating: String = "pg",
        @Query("bundle") bundle: String = "messaging_non_clips"
    ): GiphyResponse?
}