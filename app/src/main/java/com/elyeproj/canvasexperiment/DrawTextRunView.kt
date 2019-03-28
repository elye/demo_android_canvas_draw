package com.elyeproj.canvasexperiment

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class DrawTextRunView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    companion object {
        private const val TEXT = "عربى"
    }

    private val textBound by lazy {
        val textBound = Rect()
        projectResources.paint.getTextBounds(TEXT, 0, TEXT.length, textBound)
        textBound
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return
        canvas.drawTextRun(TEXT,
            1, TEXT.length - 1,
            0, TEXT.length,
            width/2f, height/3f - textBound.exactCenterY(),
            true, projectResources.paint)

        canvas.drawTextRun(TEXT,
            1, TEXT.length -1,
            1, TEXT.length -1,
            width/2f, height*2/3f - textBound.exactCenterY(),
            true, projectResources.paint)
    }
}
