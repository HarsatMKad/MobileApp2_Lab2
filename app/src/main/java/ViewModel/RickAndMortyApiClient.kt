package ViewModel

import Data.CharacterAPI
import Data.RickAndMortyApiService
import Data.RickAndMortyApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.w3c.dom.CharacterData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RickAndMortyApiClient {
    suspend fun getApiProduct(page: Int): CharacterAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl(RickAndMortyApp.baseURL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val productAPI = retrofit.create(RickAndMortyApiService::class.java)

        val corut = CoroutineScope(Dispatchers.IO).async {
            val characters = productAPI.getCharacters(page)
            return@async characters
        }

        return corut.await()
    }
}