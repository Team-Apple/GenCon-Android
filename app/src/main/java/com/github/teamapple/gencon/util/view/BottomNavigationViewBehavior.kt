package com.github.teamapple.gencon.util.view

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.View


@Suppress("unused")
class BottomNavigationViewBehavior(context: Context, attrs: AttributeSet?) : CoordinatorLayout.Behavior<BottomNavigationView>(context, attrs) {
    private var height = 0f
    private var isAnimate = false
    private var lastPosition = 0
    private var snacking = false


    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: BottomNavigationView,
                                     directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }


    override fun layoutDependsOn(parent: CoordinatorLayout, child: BottomNavigationView, dependency: View): Boolean {
        return dependency is AppBarLayout.Behavior || dependency is Snackbar.SnackbarLayout
    }

    override fun onLayoutChild(parent: CoordinatorLayout, child: BottomNavigationView,
                               layoutDirection: Int): Boolean {
        height = child.height.toFloat()
        return super.onLayoutChild(parent, child, layoutDirection)
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: BottomNavigationView,
                                target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)
        if (dyConsumed < 0) {
            child.clearAnimation()
            child.animate().translationY(0f).duration = 200
        } else if (dyConsumed > 0) {
            child.clearAnimation()
            child.animate().translationY(height).duration = 200
        }
    }
}
