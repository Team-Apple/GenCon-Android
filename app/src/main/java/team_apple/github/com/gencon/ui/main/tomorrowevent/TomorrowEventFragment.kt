package team_apple.github.com.gencon.ui.main.tomorrowevent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import team_apple.github.com.gencon.R

class TomorrowEventFragment :Fragment() {
    companion object {
        fun newInstance() = TomorrowEventFragment()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_tomorrow_event, container, false)
    }
}
