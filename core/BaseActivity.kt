package com.ktvipin.templatedemo.core

import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ktvipin.templatedemo.BR

/**
 * Created by Vipin KT on 27/05/20
 */
abstract class BaseActivity<D : ViewDataBinding, V : BaseViewModel> : AppCompatActivity(){

    @get:LayoutRes
    protected abstract val layoutId: Int

    protected abstract val viewModelClass: Class<V>

    internal val viewModel:V by lazy { ViewModelProvider(this).get(viewModelClass) }

    internal lateinit var binding: D
        private set


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.onActivityCreated(intent.extras)

        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this

        onCreated(savedInstanceState,intent.extras)
    }

    open fun onCreated(savedInstanceState: Bundle?, extras: Bundle?) { }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModel.onActivityResult(requestCode, resultCode, data)
    }
}