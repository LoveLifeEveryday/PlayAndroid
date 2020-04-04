package zqx.rj.com.playandroid.common

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import zqx.rj.com.playandroid.R

/**
 *  author: HyJame
 *  date:   2020/4/4
 *  desc:   需要为 Toolbar 控件设置id 为 toolbar
 */
abstract class ToolbarActivity : AppCompatActivity() {

    private var isInitToolbar = false

    fun setToolbarTitle(title: String) {
        if (!isInitToolbar) initToolbar()

        supportActionBar?.title = title
    }

    private fun initToolbar() {

        if (isInitToolbar) return

        isInitToolbar = true
        findViewById<Toolbar>(R.id.toolbar)?.apply { setSupportActionBar(this) }
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            //将滑动菜单显示出来
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}