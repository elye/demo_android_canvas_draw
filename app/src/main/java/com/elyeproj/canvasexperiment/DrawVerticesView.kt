package com.elyeproj.canvasexperiment

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class DrawVerticesView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    companion object {
        const val DUMMYCOLOR =  -0x100000
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return

        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        val indices = shortArrayOf(0, 1, 2, 0, 2, 3)

        val verticesColors = intArrayOf(
            Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
            DUMMYCOLOR, DUMMYCOLOR, DUMMYCOLOR, DUMMYCOLOR, DUMMYCOLOR, DUMMYCOLOR)

        val verts = floatArrayOf(width/2f, 0f, 0f, height/2f, width/2f, height.toFloat(), width.toFloat(), height/2f)

        canvas.drawVertices(
            Canvas.VertexMode.TRIANGLES,
            verts.size, verts, 0,
            null, 0,
            verticesColors, 0,
            //null, 0,
            indices, 0, indices.size,
            projectResources.paint
        )
    }
}
