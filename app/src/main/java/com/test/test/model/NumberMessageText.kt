package com.test.test.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class NumberMessageText {
    @SerializedName("text")
    @Expose
    var text: String? = null

    @SerializedName("number")
    @Expose
    var number: String? = null

    @SerializedName("found")
    @Expose
    var found: Boolean? = null

    @SerializedName("type")
    @Expose
    var type: String? = null
}