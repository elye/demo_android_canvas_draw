package com.elyeproj.canvasexperiment

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class DrawLinesView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return
        canvas.drawLines(
            listOf(
                0f + paddingStart, 0f + paddingTop, (width / 2f), (height - paddingBottom).toFloat(),
                width / 2f, (height - paddingBottom).toFloat(), (width - paddingEnd).toFloat(), (0f + paddingStart)
            ).toFloatArray(),
            projectResources.paint
        )
    }
}
