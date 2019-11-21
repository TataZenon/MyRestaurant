package ac.th.ssru.tarou.myrestaurant.adapter

import ac.th.ssru.tarou.myrestaurant.R
import ac.th.ssru.tarou.myrestaurant.adapter.holder.MenuGroupViewHolder
import ac.th.ssru.tarou.myrestaurant.dao.MenuGroup
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MenuGroupAdapter(
    private  var menuGroup: MutableList<MenuGroup> = mutableListOf(),
    private val listener:Listener
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var selectedPosition: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val resLayout: Int

        if (viewType == VIEW_SELECTED_TYPE){
            resLayout = R.layout.menu_group_view_selected

        } else {
            resLayout = R.layout.menu_group_view
        }


        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    resLayout, parent,false)
        return MenuGroupViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menuGroup.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MenuGroupViewHolder){
            holder.bind(menuGroup[position])
            holder.itemView.setOnClickListener{
                listener.onMenuGroupClickListener(menuGroup[position])
                val tempPosition = selectedPosition
                selectedPosition = position
                notifyItemChanged(tempPosition)
                notifyItemChanged(selectedPosition)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (selectedPosition == position){
            VIEW_SELECTED_TYPE}
        else{
            VIEW_NORMAL_TYPE
        }
    }

    fun setMenuGroup(menuGroups: MutableList<MenuGroup>) {
        this.selectedPosition = 0
        this.menuGroup = menuGroups
        notifyDataSetChanged()
    }

    companion object{
        val VIEW_SELECTED_TYPE =1
        val VIEW_NORMAL_TYPE = 0
    }

    interface Listener {
        fun onMenuGroupClickListener(menuGroup: MenuGroup)
    }
}