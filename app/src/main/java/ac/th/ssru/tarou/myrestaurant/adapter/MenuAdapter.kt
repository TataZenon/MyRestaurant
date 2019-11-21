package ac.th.ssru.tarou.myrestaurant.adapter

import ac.th.ssru.tarou.myrestaurant.R
import ac.th.ssru.tarou.myrestaurant.adapter.holder.MenuViewHolder
import ac.th.ssru.tarou.myrestaurant.dao.Menu
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private var menus: MutableList<Menu> = mutableListOf()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_view, parent, false)

        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menus.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MenuViewHolder){
            holder.bind(menus[position])
        }
    }

    fun setMenus(menus: MutableList<Menu>) {
        this.menus = menus
        notifyDataSetChanged()
    }
}