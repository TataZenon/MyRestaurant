package ac.th.ssru.tarou.myrestaurant.mock

import ac.th.ssru.tarou.myrestaurant.dao.Menu
import ac.th.ssru.tarou.myrestaurant.dao.MenuGroup
import kotlin.math.floor

object Mock {
    fun createMenuGroups(): MutableList<MenuGroup> {
        val menuGroups: MutableList<MenuGroup> = mutableListOf()
        val size = (3..10).random()

        for (id in 1..size) {
            menuGroups.add(MenuGroup(id, "กลุ่ม $id", createMenus(id)))
        }

        return menuGroups
    }

    private fun createMenus(gruId: Int): MutableList<Menu> {
        val menus: MutableList<Menu> = mutableListOf()
        val size: Int = (5..10).random()

        for (index in 0 until size) {
            val id = (gruId * 10) + index
            val name = "เมนู $id"
            val image = ""
            val price = floor(id * 3.0 / index + 100.0 / 2.0)
            menus.add(Menu(id, name, image, price))
        }

        return menus
    }
}