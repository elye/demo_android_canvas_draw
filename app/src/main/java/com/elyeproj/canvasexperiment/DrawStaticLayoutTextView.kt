package com.elyeproj.canvasexperiment

import android.content.Context
import android.graphics.Canvas
import android.text.StaticLayout
import android.util.AttributeSet
import android.view.View


class DrawStaticLayoutTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    companion object {
        private const val TEXT = "Too long a line to display in one line, and let it auto wrap go to next line.\nCan handle \"\\n\" as well."
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return

        val staticLayout =
            StaticLayout.Builder.obtain(
                TEXT, 0, TEXT.length, projectResources.textPaint, width
            ).build()

        canvas.save()
        canvas.translate(width / 2f, (height - staticLayout.height)/2f)
        staticLayout.draw(canvas)
        canvas.restore()
    }
}
