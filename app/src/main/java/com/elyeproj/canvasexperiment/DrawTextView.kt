package com.elyeproj.canvasexperiment

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class DrawTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    companion object {
        private const val TEXT = "Testing 123"
    }
    private val textBound by lazy {
        val textBound = Rect()
        projectResources.paint.getTextBounds(TEXT, 0, TEXT.length, textBound)
        textBound
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return
        canvas.drawText(TEXT, width/2f, height/2f - textBound.exactCenterY(), projectResources.paint)
    }
}
