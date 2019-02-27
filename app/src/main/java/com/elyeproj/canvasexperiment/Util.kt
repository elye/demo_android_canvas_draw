package com.elyeproj.canvasexperiment

import android.content.res.Resources
import android.graphics.Color
import android.graphics.Paint
import android.util.TypedValue
import java.lang.IllegalStateException

inline fun <reified T> Resources.dpToPx(value: Int): T {
    val result = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value.toFloat(), displayMetrics
    )

    return when (T::class) {
        Float::class -> result as T
        Int::class -> result.toInt() as T
        else -> throw IllegalStateException("Type not supported")
    }
}

lateinit var projectResources: ProjectResources

class ProjectResources(private val resources: Resources) {
    val paint by lazy {
        Paint()
            .apply { color = Color.BLACK }
            .apply { style = Paint.Style.STROKE }
            .apply { isAntiAlias = true }
            .apply { strokeWidth = resources.dpToPx(4) }
    }
}
