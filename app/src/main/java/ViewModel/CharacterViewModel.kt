package ViewModel

import Data.CharacterAPI
import Data.RickAndMortyApiService
import Data.RickAndMortyApp
import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterViewModel() : ViewModel() {
    var application = Application()
    var CharacterData: MutableLiveData<CharacterAPI> = MutableLiveData()
    var page = 1

     fun parsData() {
          CoroutineScope(Dispatchers.IO).launch {
             CharacterData.postValue(RickAndMortyApiClient().getApiProduct(page))
         }
    }

    fun upPage(): Boolean{
        if(CharacterData.value?.info?.next != null){
            page += 1
            return true
        } else{
            return false
        }
    }

    fun downPage(): Boolean{
        if(CharacterData.value?.info?.prev != null){
            page -= 1
            return true
        } else{
            return false
        }
    }
}