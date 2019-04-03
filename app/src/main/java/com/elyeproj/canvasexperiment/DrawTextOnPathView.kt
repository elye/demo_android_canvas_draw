package com.elyeproj.canvasexperiment

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class DrawTextOnPathView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    companion object {
        private const val TEXT = "Test 123"
    }

    private val path by lazy {
        val path = Path()
        path.moveTo(0f + paddingStart, 0f + paddingTop)
        path.lineTo((width/2f), (height - paddingBottom).toFloat())
        path.lineTo((width - paddingEnd).toFloat(), 0f + paddingTop)
        path
    }

    private val textBound by lazy {
        val textBound = Rect()
        projectResources.paint.getTextBounds(TEXT, 0, TEXT.length, textBound)
        textBound
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return
        canvas.drawPath(path, projectResources.paintLight)
        canvas.drawTextOnPath(TEXT, path,
            0f, -textBound.exactCenterY(),
            projectResources.paint)
    }
}
