package com.app.showme.Api

import com.app.showme.UserModel

data class ResponseData(
    var page: Int,
    var per_page: Int,
    var total: Int,
    var total_pages: Int,
    var data: List<UserModel>
)