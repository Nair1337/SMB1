package com.example.shoppinglist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.data.Product

class ProductListAdapter(
    private val onDeleteProduct: (Int) -> Unit
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

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
        private val kupione = view.findViewById<TextView>(R.id.czyKupione)

        fun bind(product: Product, onDeleteProduct: (Int) -> Unit) {
            name.text = product.name_of_product
            price.text = product.price_of_product.toString()
            ilosc.text = product.how_many_products.toString()

            if (product.if_bought) {
                kupione.text = "Kupione"
            } else {
                kupione.text = "Nie kupione"
            }

            bt_del.setOnClickListener {
                onDeleteProduct(product.id_of_product)
            }
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, UpdateProductActivity::class.java)
                intent.putExtra(UpdateProductActivity.KEY, product)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_product, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position]) {
            onDeleteProduct(it)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int = data.size
}