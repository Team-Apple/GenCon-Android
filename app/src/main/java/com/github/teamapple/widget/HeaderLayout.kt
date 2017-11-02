package com.github.teamapple.widget

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.widget.FrameLayout

//no-op
@CoordinatorLayout.DefaultBehavior(AppBarLayout.ScrollingViewBehavior::class)
class HeaderLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr)
