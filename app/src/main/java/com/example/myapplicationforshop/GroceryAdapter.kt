package com.example.myapplicationforshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroceryAdapter(
    private val itemList: List<GroceryItem>,
    private val onAddToCart: (GroceryItem) -> Unit
) : RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder>() {

    class GroceryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvMRP: TextView = view.findViewById(R.id.tvMRP)
        val btnAddToCart: Button = view.findViewById(R.id.btnAddToCart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grocery, parent, false)
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        val item = itemList[position]
        holder.tvName.text = item.name
        holder.tvMRP.text = "₹${item.mrp}"
        holder.btnAddToCart.text = if (item.isAdded) "Added" else "Add to Cart"

        holder.btnAddToCart.setOnClickListener {
            item.isAdded = true
            onAddToCart(item)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = itemList.size
}
