package com.shokal.cricjass.models.palyerWithCareer

data class Data(
    val battingstyle: String,
    val bowlingstyle: String,
    val career: List<Career>,
    val country_id: Int,
    val dateofbirth: String,
    val firstname: String,
    val fullname: String,
    val gender: String,
    val id: Int,
    val image_path: String,
    val lastname: String,
    val position: Position,
    val resource: String,
    val updated_at: String
)