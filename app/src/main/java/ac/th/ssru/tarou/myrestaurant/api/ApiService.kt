package ac.th.ssru.tarou.myrestaurant.api

import ac.th.ssru.tarou.myrestaurant.dao.GetMenusResult
import retrofit2.Call
import retrofit2.http.POST

interface ApiService {
    @POST("bunz")
    fun getMenus(): Call<GetMenusResult>

}