package com.github.teamapple.widget

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.github.teamapple.gencon.R


class HeaderLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    fun setExpanded(expanded: Boolean) {

    }

    @Suppress("unused")
    class ScrollingViewBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>(context, attrs) {

        override fun layoutDependsOn(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
            return dependency is HeaderLayout
        }

        override fun onMeasureChild(parent: CoordinatorLayout, child: View, parentWidthMeasureSpec: Int, widthUsed: Int, parentHeightMeasureSpec: Int, heightUsed: Int): Boolean {
            val childLpHeight = child.layoutParams.height
            if (childLpHeight == ViewGroup.LayoutParams.MATCH_PARENT
                    || childLpHeight == ViewGroup.LayoutParams.WRAP_CONTENT) {
                val header = parent.getDependencies(child).firstOrNull { it is HeaderLayout } as HeaderLayout?
                if (header != null) {
                    val mode = if (childLpHeight == ViewGroup.LayoutParams.MATCH_PARENT) {
                        MeasureSpec.EXACTLY
                    } else {
                        MeasureSpec.AT_MOST
                    }
                    val heightMeasureSpec = MeasureSpec.makeMeasureSpec(parent.bottom - header.bottom, mode)
                    parent.onMeasureChild(child, parentWidthMeasureSpec, widthUsed, heightMeasureSpec, heightUsed)
                    return true
                }
            }
            return super.onMeasureChild(parent, child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed)
        }

        override fun onLayoutChild(parent: CoordinatorLayout, child: View, layoutDirection: Int): Boolean {
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
    }

    @Suppress("unused")
    class PullableViewBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>(context, attrs) {
        private var height = 0
        private var lastHeightDiff = 0
        private val minHeight: Int
        private var animating = false

        init {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PullableViewBehaviorParams)
            minHeight = typedArray.getDimensionPixelSize(R.styleable.PullableViewBehaviorParams_min_height, 0)
            typedArray.recycle()
            if (minHeight == 0) {
                throw IllegalAccessException("required min_height attributes ")
            }
        }

        override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout?, child: View?, directTargetChild: View?, target: View?, nestedScrollAxes: Int): Boolean {
            return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
        }

        override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View,
                                    dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int) {
            super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed)
            if (dyConsumed > 0 && !animating) {
                animate(child.height, minHeight, child)
            }
        }

        private fun animate(startValue: Int, endValue: Int, view: View) {
            val animator = ValueAnimator.ofInt(startValue, endValue)
            animator.duration = 200
            animator.addUpdateListener { animation ->
                val value = animation.animatedValue as Int
                val params = view.layoutParams.apply {
                    height = value
                }
                view.layoutParams = params
            }
            animator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                    animating = true
                }

                override fun onAnimationEnd(animation: Animator?) {
                    animating = false
                }

                override fun onAnimationCancel(animation: Animator?) {
                    animating = false
                }

                override fun onAnimationStart(animation: Animator?) {
                    animating = true
                }

            })
            animator.start()
        }
    }
}
