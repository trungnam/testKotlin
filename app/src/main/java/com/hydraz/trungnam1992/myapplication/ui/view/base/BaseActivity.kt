package com.hydraz.trungnam1992.myapplication.ui.view.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.hydraz.trungnam1992.myapplication.ui.view.BaseView

/**
 * Created by trungnam1992 on 4/24/18.
 */
abstract class BaseActivity : AppCompatActivity(), BaseView {


    abstract val layoutId: Int

    protected abstract fun initializeDagger()

    protected abstract fun initializePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initializeDagger()
        initializePresenter()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun changeFragment(fragment: BaseFragment){
        //
        fragmentManager.beginTransaction().add(android.R.id.content, fragment).commit()
    }

}
