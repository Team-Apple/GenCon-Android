package com.github.teamapple.gencon.util.ext

import android.content.Context




fun Context.toPx(dpSize:Int):Float = this.resources.displayMetrics.density *dpSize


fun Context.toDp(pxSize:Int):Float = pxSize / this.resources.displayMetrics.density
