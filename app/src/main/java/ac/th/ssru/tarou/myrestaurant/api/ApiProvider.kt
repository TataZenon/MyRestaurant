package ac.th.ssru.tarou.myrestaurant.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiProvider private constructor() {
    private val DOMAIN: String
        get() = "https://75b92ad7-4439-49f7-87b2-e71068cfc846.mock.pstmn.io/"

    companion object {
        private var instance: ApiProvider? = null

        @JvmStatic
        fun getInstance(): ApiProvider{
            if(instance == null)
                instance = ApiProvider()

            return instance!!
        }
    }

    fun connect(): ApiService {
        val retrofit = Retrofit.Builder()
        retrofit.baseUrl(DOMAIN)
        retrofit.addConverterFactory(GsonConverterFactory.create())

        return retrofit.build().create(ApiService::class.java)
    }
}