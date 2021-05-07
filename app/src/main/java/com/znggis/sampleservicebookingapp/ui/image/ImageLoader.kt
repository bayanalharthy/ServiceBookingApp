package com.znggis.sampleservicebookingapp.ui.image

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(view: ImageView, url: String)
}