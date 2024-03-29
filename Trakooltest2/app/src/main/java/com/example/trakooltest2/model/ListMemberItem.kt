package com.example.trakooltest2.model

import com.google.gson.annotations.SerializedName

data class ListMemberItem(val members: ArrayList<Member>,
                          @SerializedName("current_page") val currentPage: Int,
                          @SerializedName("total_page") val totalPage: Int)