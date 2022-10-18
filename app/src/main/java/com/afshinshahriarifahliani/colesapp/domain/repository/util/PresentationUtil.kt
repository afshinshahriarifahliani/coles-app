package com.afshinshahriarifahliani.colesapp.domain.repository.util

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.afshinshahriarifahliani.colesapp.R
import dagger.Provides

const val BASE_URL = "https://coles.com.au"

fun getCircularProgress(context: Context):CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth=10f
        centerRadius=50f
        start()
    }
}

fun ImageView.loadImage(uri: String?, circularProgressDrawable: CircularProgressDrawable){
    val options= RequestOptions()
        .placeholder(circularProgressDrawable)
        .error(R.drawable.no_image)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}