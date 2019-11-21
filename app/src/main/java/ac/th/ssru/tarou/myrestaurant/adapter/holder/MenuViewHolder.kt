package ac.th.ssru.tarou.myrestaurant.adapter.holder

import ac.th.ssru.tarou.myrestaurant.R
import ac.th.ssru.tarou.myrestaurant.dao.Menu
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MenuViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val ivMenuImage:ImageView = view.findViewById(R.id.ivMenuImage)
    private  val tvMenuName: TextView = view.findViewById(R.id.tvMenuName)
    private val tvMenuPrice: TextView = view.findViewById(R.id.tvMenuPrice)

    fun bind(menu: Menu) {
        Glide.with(itemView).load(menu.image).into(ivMenuImage)
        //ivMenuImage.setImageResource(menu.image)
        tvMenuName.text = menu.name
        tvMenuPrice.text = "฿ ${menu.price}"


    }
}