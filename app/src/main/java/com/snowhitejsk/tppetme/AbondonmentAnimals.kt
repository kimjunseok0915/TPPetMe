package com.snowhitejsk.tppetme

data class First(var response:Second)
data class Second(var body: Third)
data class Third(var items: Forth)
data class Forth(var item: MutableList<Animals> )
data class Animals(
    var age : String,
    var sexCd : String,
    var kindCd : String,
    var weight : String,
    var popfile : String,
    var specialMark : String,
    var careNm : String,
    var careTel : String,
    var careAddr : String
)
