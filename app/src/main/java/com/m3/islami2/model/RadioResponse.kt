package com.m3.islami2.model

import com.google.gson.annotations.SerializedName

data class RadioResponse(

	@field:SerializedName("radios")
	val radios: List<RadiosChannel?>? = null
)

data class RadiosChannel(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("url")
	val url: String? = null
)
