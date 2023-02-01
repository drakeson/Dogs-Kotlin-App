package ug.code.dogs.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import ug.code.dogs.model.DogBreed
import ug.code.dogs.model.DogDataBase

class DetailViewModel(application: Application): BaseViewModel(application) {

    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch(uuid: Int) {
        launch {
            val dog = DogDataBase(getApplication()).dogDao().getDog(uuid)
            dogLiveData.value = dog
        }
    }

}