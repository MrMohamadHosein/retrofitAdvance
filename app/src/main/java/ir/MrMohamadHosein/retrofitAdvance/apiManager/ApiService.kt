package ir.MrMohamadHosein.retrofitAdvance.apiManager

import com.google.gson.JsonObject
import ir.MrMohamadHosein.retrofitAdvance.apiManager.model.User
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("users")
    fun getUsers() :Call<List<User>>

    // https://dunijet.ir/api/users/20
    @GET("users/{id}")
    fun getUser( @Path("id") id_user :Int  ) :Call<User>

    // https://dunijet.ir/api/users?sort=desc
    @GET("users")
    fun getUsersSorted( @Query("sort") queryParam :String ) :Call<List<User>>

    // https://dunijet.ir/api/users
    @POST("users")
    fun insertUser( @Body body :JsonObject )

    @GET("users")
    fun authUser( @Header("Authorization") auth :String )

}