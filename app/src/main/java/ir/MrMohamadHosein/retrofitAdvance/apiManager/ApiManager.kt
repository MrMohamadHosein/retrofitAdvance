package ir.MrMohamadHosein.retrofitAdvance.apiManager

import com.google.gson.Gson
import com.google.gson.JsonObject
import ir.MrMohamadHosein.retrofitAdvance.apiManager.model.User
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class ApiManager {
    private val apiService :ApiService
    init {

        val okHttpClient = OkHttpClient.Builder().addInterceptor {

                val oldRequest = it.request()

                val newRequest = oldRequest.newBuilder()


                /*  Baraye ezafekardan Authorization be header   */

                newRequest.addHeader("Authorization" , "1ad698149ASD6F51ads65f4as4sa6f4")

                it.proceed( newRequest.build() )
            }.build()

        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)

        // apiService.getUser(20) working with path
        // apiService.getUsersSorted("desc") working with Query Param

        // convert json to dataclass and vice-versa =>
//        val gson = Gson()
//        val data = gson.toJson(user)
//        val user = gson.fromJson<User>(json1)

        // @post method and send data =>
//        val jsonObject = JsonObject()
//        jsonObject.addProperty("name" , "amirHosseinMohammadi")
//        apiService.insertUser(jsonObject)

    }

    fun getUsers(callback :ApiCallback<List<User>> ) {

        apiService.getUsers().enqueue(object :Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val body = response.body()!!
                callback.onSuccess(body)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                val message = t.message!!
                callback.onError(message)
            }

        } )

    }


    fun getUsersSorted(callback: ApiCallback<List<User>>){


        apiService.getUsersSorted("desc").enqueue(object :Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val body = response.body()!!
                callback.onSuccess(body)            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                val message = t.message!!
                callback.onError(message)            }

        })

    }


    interface ApiCallback<T> {

        fun onSuccess( data :T )
        fun onError(errorMessage :String)

    }
}