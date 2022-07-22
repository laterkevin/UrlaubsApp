package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.data.model.Category
import com.example.recyclerview.ui.HomeFragmentDirections

// der Adapter braucht den Context um auf String Resourcen zuzugreifen
// und die Liste an Jokes um sie für die RecyclerView vorzubereiten
class CategoryAdapter(
    private val dataset: List<Category>
) : RecyclerView.Adapter<CategoryAdapter.ItemViewHolder>() {

    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val categoryText: TextView = view.findViewById(R.id.category_text)
        val categoryLayout: ConstraintLayout = view.findViewById(R.id.category_layout)
    }

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // das itemLayout wird gebaut
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.categoryText.text = item.name.uppercase()
        holder.categoryLayout.setBackgroundResource(item.imageResource)

        holder.categoryLayout.setOnClickListener {
            holder.view.findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToCategoryFragment(item.name))
        }
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}
