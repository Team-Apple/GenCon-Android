package com.github.teamapple.gencon.extension

import android.view.View

fun View.visibility(shown: Boolean){
    if (shown) {
        this.visibility = View.VISIBLE
    }else{
        this.visibility = View.GONE
    }
}
