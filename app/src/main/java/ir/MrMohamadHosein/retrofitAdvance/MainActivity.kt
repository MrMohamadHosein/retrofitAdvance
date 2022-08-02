package ir.MrMohamadHosein.retrofitAdvance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import ir.MrMohamadHosein.retrofitAdvance.apiManager.ApiManager
import ir.MrMohamadHosein.retrofitAdvance.apiManager.ApiService
import ir.MrMohamadHosein.retrofitAdvance.databinding.ActivityMainBinding
import ir.MrMohamadHosein.retrofitAdvance.apiManager.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val apiManager = ApiManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


      /*  binding.btnGetData.setOnClickListener {
            apiManager.getUsers(object : ApiManager.ApiCallback<List<User>> {
                override fun onSuccess(data: List<User>) {
                    Log.v("testApi", data.toString())

                    data.forEach {

                        Log.d("testApi", it.name)
                        Log.d("testApi", it.phone)

                    }
                }

                override fun onError(errorMessage: String) {
                    Log.v("testApi", errorMessage)
                }
            })
        }*/






        binding.btnGetData.setOnClickListener {



            apiManager.getUsers(object : ApiManager.ApiCallback<List<User>> {
                override fun onSuccess(data: List<User>) {

                    data.forEach {

                        Log.d("getUsers", it.name)

                    }
                }

                override fun onError(errorMessage: String) {
                    Log.v("getUsers", errorMessage)
                }
            })






            apiManager.getUsersSorted(object : ApiManager.ApiCallback<List<User>> {
                override fun onSuccess(data: List<User>) {

                    data.forEach {

                        Log.d("getUsersSorted", it.name)
                        //Log.d("testApi", it.phone)

                    }
                }

                override fun onError(errorMessage: String) {
                    Log.v("getUsersSorted", errorMessage)
                }
            })
        }










    }


}