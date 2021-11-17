package com.example.shoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.data.Product

class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private var data = ArrayList<Product>()

    /*
    * Lista danych na ta na ktora podam i odswieza widok (notifydatasetchanged)
    * */
    fun setData(data: ArrayList<Product>) {
        this.data = ArrayList(data)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val name = view.findViewById<TextView>(R.id.Name)
        private val price = view.findViewById<TextView>(R.id.Cena)
        private val ilosc = view.findViewById<TextView>(R.id.Ilosc)
        private val bt_del = view.findViewById<ImageView>(R.id.Delete)

        fun bind(product: Product) {
            name.text = product.name_of_product
            price.text = product.price_of_product.toString()
            ilosc.text = product.how_many_products.toString()
            bt_del.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_product, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}