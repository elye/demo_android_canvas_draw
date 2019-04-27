package com.elyeproj.canvasexperiment

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class DrawPosTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    companion object {
        private const val TEXT = "Testing 123"
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return
        canvas.drawPosText(TEXT.toCharArray(), 1, 3,
            listOf(width/1.5f, height/1.5f, width/2f, height/2f, width/3f, height/3f).toFloatArray(), projectResources.paint)
    }
}
