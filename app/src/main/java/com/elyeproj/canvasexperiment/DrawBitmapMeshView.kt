package com.elyeproj.canvasexperiment

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class DrawBitmapMeshView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val bitmap by lazy {
        BitmapFactory.decodeResource(resources, R.drawable.image)
    }

    private val firstX by lazy { 0f + paddingLeft }
    private val firstY by lazy { 0f + paddingTop }
    private val secondX by lazy { width/5f }
    private val secondY by lazy { height/3f }
    private val thirdX by lazy { width.toFloat() - paddingRight }
    private val thirdY by lazy { height.toFloat() - paddingBottom }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return

        canvas.drawBitmapMesh(bitmap, 2, 2,
            floatArrayOf(
                firstX, firstY, secondX, firstY, thirdX, firstY,
                firstX, secondY, secondX, secondY, thirdX, secondY,
                firstX, thirdY, secondX, thirdY, thirdX, thirdY),
            0, null, 0, null)

        canvas.drawLine(firstX, firstY, firstX, thirdY, projectResources.paintLight)
        canvas.drawLine(secondX, firstY, secondX, thirdY, projectResources.paintLight)
        canvas.drawLine(thirdX, firstY, thirdX, thirdY, projectResources.paintLight)

        canvas.drawLine(firstX, firstY, thirdX, firstY, projectResources.paintLight)
        canvas.drawLine(firstX, secondY, thirdX, secondY, projectResources.paintLight)
        canvas.drawLine(firstX, thirdY, thirdX, thirdY, projectResources.paintLight)
    }
}
