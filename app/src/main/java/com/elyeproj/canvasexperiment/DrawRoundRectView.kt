package com.elyeproj.canvasexperiment

import android.content.Context
import android.graphics.Canvas
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class DrawRoundRectView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {


    private val rect by lazy {
        RectF(
            0f + paddingStart,
            0f + paddingTop,
            (width - paddingEnd).toFloat(),
            (height - paddingBottom).toFloat()
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return
        canvas.drawRoundRect(rect, resources.dpToPx(10), resources.dpToPx(10), projectResources.paint)
    }
}
