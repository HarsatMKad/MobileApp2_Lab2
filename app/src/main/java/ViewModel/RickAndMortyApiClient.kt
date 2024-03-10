package ViewModel

import Data.RickAndMortyApiService
import Data.RickAndMortyApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.CharacterData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RickAndMortyApiClient {
    fun getApiProduct(): RickAndMortyApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(RickAndMortyApp.baseURL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val productAPI = retrofit.create(RickAndMortyApiService::class.java)
        return productAPI
    }
}