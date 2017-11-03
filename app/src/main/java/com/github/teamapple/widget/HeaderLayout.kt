package com.github.teamapple.widget

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import timber.log.Timber


class HeaderLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {

    }

    @Suppress("unused")
    class ScrollingViewBehavior(context: Context, attrs: AttributeSet?) : CoordinatorLayout.Behavior<View>(context, attrs) {

        override fun layoutDependsOn(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
            return dependency is HeaderLayout
        }

        override fun onLayoutChild(parent: CoordinatorLayout, child: View, layoutDirection: Int): Boolean {
            Timber.d("onLayoutChild ")
            if (ViewCompat.getFitsSystemWindows(parent) && !ViewCompat.getFitsSystemWindows(child)) {
                ViewCompat.setFitsSystemWindows(child, true)
            }
            val header = parent.getDependencies(child).firstOrNull { it is HeaderLayout } as HeaderLayout?
            if (header != null) {
                parent.onLayoutChild(child, layoutDirection)
                ViewCompat.offsetTopAndBottom(child, header.bottom)
                return true
            }
            return false
        }

        override fun onDependentViewChanged(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
            Timber.d(" onDependentViewChanged")
            return super.onDependentViewChanged(parent, child, dependency)
        }

        override fun onNestedScroll(coordinatorLayout: CoordinatorLayout?, child: View?, target: View?, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int) {
            super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed)
            Timber.d("onNestedScroll")
        }
        override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout?, child: View?, target: View?, dx: Int, dy: Int, consumed: IntArray?) {
            super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed)
            Timber.d("onNestedPreScroll")
        }
    }

    @Suppress("unused")
    class PullableViewBehavior(context: Context, attrs: AttributeSet?) : CoordinatorLayout.Behavior<View>(context, attrs) {
        private var height = 0f
        override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout?, child: View?, directTargetChild: View?, target: View?, nestedScrollAxes: Int): Boolean {
            return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
        }


        override fun onLayoutChild(parent: CoordinatorLayout, child: View, layoutDirection: Int): Boolean {
            height = child.height.toFloat()
            return super.onLayoutChild(parent, child, layoutDirection)
        }

        override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View,
                                    dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int) {
            super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed)
            //Timber.d("onNestedScroll")
            /*if (dyConsumed > 0) {
                child.clearAnimation()
                child.animate().translationY(0f).duration = 200
            } else if (dyConsumed < 0) {
                child.clearAnimation()
                child.animate().translationY(height).duration = 200
            }*/
        }
    }
}
