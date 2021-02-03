package com.mystudio.developerstestapp.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataDevelopers(val list: List<DataDeveloper>) : Parcelable {
    @Parcelize
    data class DataDeveloper(
        val id: String,
        val name: String,
        val description: String,
        val picture: String,
        val hired: Hired
    ) : Parcelable

    enum class Hired {
        Y,
        N
    }
}
