package com.poklad.giphyjob.domain.usecases

import com.poklad.giphyjob.domain.repository.GiphyRepository
import javax.inject.Inject

class DeleteGifUseCase @Inject constructor(
    private val repository: GiphyRepository,
) {
    suspend fun deleteGif(id: String) {
        repository.deleteGif(id)
    }
}