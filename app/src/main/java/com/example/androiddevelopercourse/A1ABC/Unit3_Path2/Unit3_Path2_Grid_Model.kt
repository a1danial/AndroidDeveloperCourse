package com.example.androiddevelopercourse.A1ABC.Unit3_Path2

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val courseCount: Int,
    @DrawableRes val imageResourceId: Int
)
