package com.poklad.giphyjob.data.local.data_source

import com.poklad.giphyjob.data.common.data_sources.GiphyDataSource
import com.poklad.giphyjob.data.common.models.GifDataModel
import com.poklad.giphyjob.data.local.dao.GifDao
import com.poklad.giphyjob.data.local.models.GifEntity
import javax.inject.Inject

class CacheGifsDataSource @Inject constructor(
    private val gifDao: GifDao
) : GiphyDataSource {
    override suspend fun getTrendingGifs(): List<GifDataModel> {
        return gifDao.getAllGifs()
    }

    suspend fun saveGifs(gifs: List<GifDataModel>) {
        gifDao.clearGifs()
        gifDao.insertAll(gifs.map {
            GifEntity(
                id = it.id,
                url = it.url,
                title = it.title,
                username = it.username
            )
        })
    }
}