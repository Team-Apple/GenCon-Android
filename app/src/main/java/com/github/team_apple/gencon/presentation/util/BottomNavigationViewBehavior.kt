package com.github.team_apple.gencon.presentation.util

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.View
@Suppress("unused")
class BottomNavigationViewBehavior(context: Context?, attrs: AttributeSet?) : CoordinatorLayout.Behavior<BottomNavigationView>(context, attrs) {
    private var height = 0f

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: BottomNavigationView,
                                     directTargetChild: View, target: View, nestedScrollAxes: Int): Boolean {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun layoutDependsOn(parent: CoordinatorLayout, child: BottomNavigationView, dependency: View): Boolean {
        return dependency is AppBarLayout.Behavior
    }

    override fun onLayoutChild(parent: CoordinatorLayout, child: BottomNavigationView,
                               layoutDirection: Int): Boolean {
        height = child.height.toFloat()
        return super.onLayoutChild(parent, child, layoutDirection)
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: BottomNavigationView,
                                target: View, dxConsumed: Int, dyConsumed: Int,
                                dxUnconsumed: Int, dyUnconsumed: Int) {

        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed)
        if (dyConsumed < 0) {
            child.clearAnimation()
            child.animate().translationY(0f).duration = 200
        } else if (dyConsumed > 0) {
            child.clearAnimation()
            child.animate().translationY(height).duration = 200
        }
    }
}
