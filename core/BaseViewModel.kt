package com.ktvipin.templatedemo.core

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Vipin KT on 27/05/20
 */
abstract class BaseViewModel : ViewModel() {

    open fun onActivityCreated(extras: Bundle?) {}

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {}
}
