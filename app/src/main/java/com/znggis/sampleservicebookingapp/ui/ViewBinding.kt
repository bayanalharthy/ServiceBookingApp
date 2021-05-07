package com.znggis.sampleservicebookingapp.ui

import android.graphics.Paint
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.znggis.sampleservicebookingapp.R
import com.znggis.sampleservicebookingapp.repo.remote.data.Service


@BindingAdapter("app:visibility")
fun setVisibility(view: View, value: Boolean) {
    view.visibility = if (value) View.VISIBLE else View.GONE
}

@BindingAdapter("app:background")
fun setBackground(view: View, value: Boolean) {
    if (value) {
        view.setBackgroundResource(R.drawable.item_service_vip_bg)
    } else {
        view.setBackgroundResource(R.drawable.item_service_bg)
    }
}

@BindingAdapter("app:serviceCustomization")
fun setBackground(tv: TextView, value: Service) {
    if (value.isSpecial) {
        tv.setTextColor(ContextCompat.getColor(tv.context, R.color.white))
    } else {
        if (tv.id == R.id.tv_description)
            tv.setTextColor(ContextCompat.getColor(tv.context, R.color.grey_medium))
        else
            tv.setTextColor(ContextCompat.getColor(tv.context, R.color.vip_service))
    }
    if (tv.id == R.id.tv_discounted_price) {
        tv.paintFlags = tv.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        tv.setTextColor(ContextCompat.getColor(tv.context, R.color.discount_price))
    }

}