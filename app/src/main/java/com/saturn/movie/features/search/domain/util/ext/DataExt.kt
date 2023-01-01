package com.saturn.movie.features.search.domain.util.ext

import com.saturn.movie.features.search.domain.model.Data
import com.saturn.movie.features.search.domain.model.Size

fun Data.getPoster(size: Size = Size.M): String? {
    return when (size) {
        Size.L -> pic?.movieImgB
        Size.M -> pic?.movieImgM
        Size.S -> pic?.movieImgS
    }
}