package com.kharismarizqii.core_cocktail.exception

import com.kharismarizqii.core_cocktail.vo.RequestResults

/**
 * Created by Kharisma Rizqi on 19/11/21
 * github.com/kharismarizqii
 */
data class Failure(val requestResults: RequestResults, val throwable: Throwable, val code:String="")