package ac.th.ssru.tarou.myrestaurant.adapter.holder

import ac.th.ssru.tarou.myrestaurant.R
import ac.th.ssru.tarou.myrestaurant.dao.MenuGroup
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuGroupViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private  val tvMenuGroupName: TextView = view.findViewById(R.id.tvMenuGroupName)

    fun bind(menuGroup:MenuGroup){
        tvMenuGroupName.text = menuGroup.name
    }
}