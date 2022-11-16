package com.snowhitejsk.tppetme

data class NaverSearchResponse constructor(var total: Int, var items: MutableList<FacilityPlaces>)

data class FacilityPlaces constructor(

    var title: String,
    var link: String,
    var category: String,
    var address: String,
    var mapx: String,
    var mapy: String,
    var description: String

)