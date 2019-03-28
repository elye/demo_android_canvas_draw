package com.elyeproj.canvasexperiment

import android.content.res.Resources
import android.graphics.Color
import android.graphics.Paint
import android.util.TypedValue

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
    val paintBig by lazy {
        Paint().apply {
            color = Color.BLACK
            style = Paint.Style.STROKE
            isAntiAlias = true
            strokeWidth = resources.dpToPx(8)
            textAlign = Paint.Align.CENTER
            textSize = resources.dpToPx(30)
        }
    }

    val paint by lazy {
        Paint().apply {
            color = Color.BLACK
            style = Paint.Style.STROKE
            isAntiAlias = true
            strokeWidth = resources.dpToPx(2)
            textAlign = Paint.Align.CENTER
            textSize = resources.dpToPx(30)
        }
    }

    val paintLight by lazy {
        Paint().apply {
            color = Color.LTGRAY
            style = Paint.Style.STROKE
            isAntiAlias = true
            strokeWidth = resources.dpToPx(2)
            textAlign = Paint.Align.CENTER
            textSize = resources.dpToPx(30)
        }
    }
}
