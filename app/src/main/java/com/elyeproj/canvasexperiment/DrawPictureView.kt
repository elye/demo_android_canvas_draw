package com.elyeproj.canvasexperiment

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Picture
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class DrawPictureView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val bitmap by lazy {
        BitmapFactory.decodeResource(resources, R.drawable.image)
    }

    private val rect by lazy {
        Rect(0 + paddingLeft, 0 + paddingTop, width - paddingRight, height - paddingBottom)
    }

    private val picture by lazy {
        val picture = Picture()
        val pCanvas = picture.beginRecording(width, height)
        pCanvas.drawBitmap(bitmap, null, rect, null)
        picture.endRecording()
        picture
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return
        canvas.drawPicture(picture)
    }
}
