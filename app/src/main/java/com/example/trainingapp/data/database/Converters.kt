package com.example.trainingapp.data.database

import androidx.room.TypeConverter
import com.google.android.gms.maps.model.LatLng

class Converters{

    @TypeConverter
    fun latLngToString(latLng: LatLng) : String{
        return "${latLng.latitude},${latLng.longitude}"
    }

    @TypeConverter
    fun stringToLatLng(string: String) : LatLng {
        val list = string.split(",")
        return LatLng(list.first().toDouble(), list.last().toDouble())
    }
}