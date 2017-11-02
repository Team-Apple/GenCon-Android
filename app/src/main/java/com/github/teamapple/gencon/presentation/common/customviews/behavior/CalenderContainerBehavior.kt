package com.github.teamapple.gencon.presentation.common.customviews.behavior

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.View
import timber.log.Timber

class CalenderContainerBehavior<V:View>(context: Context?, attrs: AttributeSet?) : CoordinatorLayout.Behavior<V>(context, attrs) {

    init {
        Timber.d("CalenderContainerBehavior init")
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout?, child: V, directTargetChild: View?, target: View?, nestedScrollAxes: Int): Boolean {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
    }
    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout?, child: V, target: View?, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed)
        Timber.d("CalenderContainerBehavior nestedScroll")
    }
}
