package com.elyeproj.canvasexperiment

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class DrawPaintView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    companion object {
        private const val TEXT = "Testing 123"
    }
    private val gradientPaint by lazy {
        Paint().apply {
            shader = RadialGradient(
                width/2f,
                height/2f,
                height/2f,
                Color.GREEN,
                Color.RED,
                Shader.TileMode.MIRROR
            )
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return
        canvas.drawPaint(gradientPaint)
    }
}
