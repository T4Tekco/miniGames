package com.android.t4tek.data.remote.response

import androidx.annotation.Keep
import com.android.t4tek.domain.json_model.Game


@Keep
data class JsonListGame(
    val games: List<Game>
)