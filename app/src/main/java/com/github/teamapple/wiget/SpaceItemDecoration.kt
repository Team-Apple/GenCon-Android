package com.github.teamapple.wiget

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.github.teamapple.gencon.extension.toPx

class SpaceItemDecoration private constructor(val spaceSize: Int) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect?.set(0, spaceSize, 0, spaceSize)
    }

    companion object {
        fun createByDpSize(context:Context, dpSize:Int) = SpaceItemDecoration(context.toPx(dpSize).toInt())
        fun createByPxSize(pxSize:Int) = SpaceItemDecoration(pxSize)
        fun createFromResource(context: Context,resId:Int) = SpaceItemDecoration(context.resources.getDimensionPixelSize(resId))
    }
}
