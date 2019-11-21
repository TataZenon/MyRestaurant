package ac.th.ssru.tarou.myrestaurant.dao

import com.google.gson.annotations.SerializedName

class GetMenusResult (
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("data")
    val data: MutableList<MenuGroup>
)