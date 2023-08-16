package com.example.trainingapp.ui

import android.graphics.Color
import android.graphics.PorterDuff
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingapp.data.database.tables.session_table.SessionTable
import com.example.trainingapp.fragments.homefragment.SessionListAdapter

@BindingAdapter("icon")
fun bindIcon(imgView: ImageView, icon:String) {
    val iconList = icon.split(";")
    val hexColor = iconList[1]
    val icon = iconList[0]


    val drawable = ContextCompat.getDrawable(imgView.context, imgView.resources.getIdentifier("ic_icon_$icon", "drawable", imgView.context.packageName))
    drawable?.setColorFilter(Color.parseColor(hexColor), PorterDuff.Mode.SRC_IN)
    imgView.setImageDrawable(drawable)
}
/*
@BindingAdapter("listPrograms")
fun bindProgramRecyclerView(recyclerView: RecyclerView, data: List<UserProgramTable>? ) {
    val adapter = recyclerView.adapter as TripListAdapter
    adapter.submitList(data)
}
*/

@BindingAdapter("listSessions")
fun bindSessionRecyclerView(recyclerView: RecyclerView, data: List<SessionTable>? ) {
    val adapter = recyclerView.adapter as SessionListAdapter
    adapter.submitList(data)
}

