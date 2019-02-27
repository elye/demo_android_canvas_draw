package com.elyeproj.canvasexperiment

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class DrawPathView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val path by lazy {
        val path = Path()
        path.moveTo(0f + paddingStart, 0f + paddingTop)
        path.lineTo((width - paddingEnd).toFloat(), (height - paddingBottom).toFloat())
        path.moveTo(0f + paddingStart, (height - paddingBottom).toFloat())
        path.lineTo((width - paddingEnd).toFloat(), 0f + paddingTop)
        path
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return
        canvas.drawPath(path, projectResources.paint)
    }
}
