package ac.th.ssru.tarou.myrestaurant.dao

import com.google.gson.annotations.SerializedName

data class MenuGroup(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("menus")
    var menus: MutableList<Menu>
)