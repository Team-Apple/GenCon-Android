package com.github.team_apple.gencon.presentation.util

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.View
import timber.log.Timber

class FloatingActionButtonBehavior(context: Context?, attrs: AttributeSet?) : FloatingActionButton.Behavior(context, attrs) {

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, directTargetChild: View, target: View, nestedScrollAxes: Int): Boolean {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed)
        Timber.d("dxConsumed:$dxConsumed dyConsumed:$dyConsumed dxUnconsumed:$dxUnconsumed dyUnconsumed:$dyUnconsumed")
        if (child.visibility == View.VISIBLE && dyConsumed > 0) {
            child.hide()
        } else if (child.visibility == View.GONE && dyConsumed < 0) {
            child.show()
        }
    }
}
