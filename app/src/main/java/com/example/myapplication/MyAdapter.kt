package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class MyAdapter(val list: List<Book>) : RecyclerView.Adapter<MyAdapter.MyItemBook>(){
    class MyItemBook(view: View) : RecyclerView.ViewHolder(view) {
        val name : TextView = view.findViewById(R.id.bookName)
        val year : TextView = view.findViewById(R.id.bookYear)
        val image: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyItemBook {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.book_item,parent,false)
        return MyItemBook(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyItemBook, position: Int) {
        holder.name.text = list.get(position).name
        holder.year.text = "Год выхода: ${list.get(position).year}"
        Picasso.get().load(list.get(position).image).into(holder.image)

        holder.itemView.setOnClickListener {
            Snackbar.make(holder.itemView,"N $position",Snackbar.LENGTH_LONG).show()
        }
    }

}