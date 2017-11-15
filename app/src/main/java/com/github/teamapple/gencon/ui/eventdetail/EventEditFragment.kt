package com.github.teamapple.gencon.ui.eventdetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.view.*
import com.github.teamapple.gencon.R

class EventEditFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_event_edit, menu)
        val menuItem = menu.findItem(R.id.menu_item_event_submit)
        val drawable = menuItem?.icon?.let { icon ->
            DrawableCompat.wrap(icon)
        } ?: return
        DrawableCompat.setTint(drawable, ContextCompat.getColor(context, R.color.white))
        menuItem.icon = drawable
    }


    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

}
