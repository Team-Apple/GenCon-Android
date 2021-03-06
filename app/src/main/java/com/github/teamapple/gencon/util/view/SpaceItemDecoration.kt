package com.github.teamapple.gencon.util.view

import android.content.Context
import android.graphics.Rect
import android.support.annotation.DimenRes
import android.support.v7.widget.RecyclerView
import android.view.View

class SpaceItemDecoration private constructor(private val spaceSize: Int) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect?.set(0, spaceSize, 0, spaceSize)
    }

    companion object {
        fun createFromResource(context: Context,@DimenRes resId:Int) = SpaceItemDecoration(context.resources.getDimensionPixelSize(resId))
    }
}
