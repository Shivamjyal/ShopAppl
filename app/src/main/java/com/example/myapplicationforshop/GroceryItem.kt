package com.example.myapplicationforshop

data class GroceryItem(
    val name: String,
    val mrp: Double,
    var isAdded: Boolean = false
)
