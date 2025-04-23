package com.example.myapplicationforshop

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tvTotalBill: TextView
    private lateinit var btnAddItem: Button
    private lateinit var adapter: GroceryAdapter
    private val groceryList = mutableListOf<GroceryItem>()
    private var totalBill = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        tvTotalBill = findViewById(R.id.tvTotalBill)
        btnAddItem = findViewById(R.id.btnAddItem)

        groceryList.add(GroceryItem("Milk", 50.0))
        groceryList.add(GroceryItem("Bread", 30.0))
        groceryList.add(GroceryItem("Eggs", 60.0))

        adapter = GroceryAdapter(groceryList) { item ->
            totalBill += item.mrp
            tvTotalBill.text = "Total Bill: ₹$totalBill"
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnAddItem.setOnClickListener {
            showAddItemDialog()
        }
    }

    private fun showAddItemDialog() { /* Same function as above */ }
}
