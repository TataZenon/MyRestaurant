package ac.th.ssru.tarou.myrestaurant

import ac.th.ssru.tarou.myrestaurant.adapter.MenuAdapter
import ac.th.ssru.tarou.myrestaurant.adapter.MenuGroupAdapter
import ac.th.ssru.tarou.myrestaurant.api.ApiProvider
import ac.th.ssru.tarou.myrestaurant.dao.GetMenusResult
import ac.th.ssru.tarou.myrestaurant.dao.MenuGroup
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MenuGroupAdapter.Listener, Callback<GetMenusResult> {
    private var menuGroups: MutableList<MenuGroup> = mutableListOf()
    private var menuAdapter: MenuAdapter? = null
    private var menuGroupAdapter: MenuGroupAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //menuGroups.addAll(Mock.createMenuGroups())
        initReloading()
        createMenuGroupAdapter()
        createMenuAdapter()
        callApi()
    }

    private fun initReloading() {
        srfReloading.setOnRefreshListener{
            srfReloading.isRefreshing = false
            callApi()
        }
    }

    private fun callApi() {
        showLoading()

        ApiProvider.getInstance().connect().getMenus().enqueue(this)
    }

    private fun createMenuGroupAdapter() {
        rvMenuGroup.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        menuGroupAdapter = MenuGroupAdapter(listener = this)
        rvMenuGroup.adapter = menuGroupAdapter
    }

    private fun createMenuAdapter() {
        rvMenu.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        menuAdapter = MenuAdapter()
        rvMenu.adapter = menuAdapter
    }

    override fun onMenuGroupClickListener(menuGroup: MenuGroup) {
        menuAdapter?.setMenus(menuGroup.menus)
    }

    override fun onFailure(call: Call<GetMenusResult>, t: Throwable) {
        t.printStackTrace()
        hiddenLoading()
    }

    override fun onResponse(call: Call<GetMenusResult>, response: Response<GetMenusResult>) {
        if (response.isSuccessful) {
            val result: GetMenusResult? = response.body()
            if (result != null) {
                onUpdateResult(result)
            } else {
                onFailure(call, Throwable("Result is null!!!"))
            }
        } else {
            onFailure(call, Throwable("Response is un successful"))
        }
        hiddenLoading()
    }

    private fun onUpdateResult(result: GetMenusResult) {
        menuGroups = result.data
        menuGroupAdapter?.setMenuGroup(menuGroups)
        menuAdapter?.setMenus(menuGroups[0].menus)
    }

    fun showLoading() {
        rlLoading.visibility = View.VISIBLE
        llContent.visibility = View.GONE
    }

    fun hiddenLoading() {
        rlLoading.visibility = View.GONE
        llContent.visibility = View.VISIBLE
    }
}