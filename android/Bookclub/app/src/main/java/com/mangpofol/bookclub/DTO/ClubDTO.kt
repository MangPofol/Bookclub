package com.mangpofol.bookclub.DTO

import java.util.*

data class ClubDTO(
    var clubId: Long? = null,
    var clubName: String? = null,
    var clubColorSet: String? = null,
    var clubLevel: Long? = null,
    var clubPresident: Long? = null,
    var createDate: Date? = null,
    var updateDate: Date? = null
)