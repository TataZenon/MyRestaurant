package ac.th.ssru.tarou.myrestaurant.dao

import com.google.gson.annotations.SerializedName

data class Menu(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("price")
    var price: Double
)