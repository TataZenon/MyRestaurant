package ac.th.ssru.tarou.myrestaurant.dao

import com.google.gson.annotations.SerializedName

class Meta (
    @SerializedName("status")
    val status:Int ,
    @SerializedName("message")
    val message: String
)