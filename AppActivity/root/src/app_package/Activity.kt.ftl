package ${escapeKotlinIdentifiers(packageName)}

import android.content.Context
import android.content.Intent
import android.os.Bundle
import ${applicationPackage}.R
import ${applicationPackage}.core.BaseActivity
import ${applicationPackage}.databinding.${underscoreToCamelCase(layoutName)}Binding

class ${activityClass} : BaseActivity<${underscoreToCamelCase(layoutName)}Binding,${viewModelClass}>() {

    override val layoutId: Int
        get() = R.layout.${layoutName}

    override val viewModelClass: Class<${viewModelClass}>
        get() = ${viewModelClass}::class.java

    override fun onCreated(savedInstanceState: Bundle?, extras: Bundle?) {
        super.onCreated(savedInstanceState, extras)
    }

    companion object{
        fun start(context: Context) {
            context.startActivity((Intent(context,${activityClass}::class.java)))
        }
    }
}
