package com.elyeproj.canvasexperiment

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class DrawColorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return
        canvas.drawColor(context.getColor(R.color.colorPrimary))
    }
}
