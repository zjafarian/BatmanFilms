package com.example.batmanfilms.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.batmanfilms.R
import com.example.batmanfilms.databinding.ItemFilmBinding
import com.example.batmanfilms.models.SearchItem
import com.squareup.picasso.Picasso

class BatmanFilmsAdapter : ListAdapter<SearchItem,
        BatmanFilmsAdapter.BatmanFilmHolder>(BatmanFilmsDiffUtilCallback()) {
    private var clickFilm : OnClickFilm? = null


    fun onClickFilm(filmClick : OnClickFilm){
        clickFilm = filmClick
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatmanFilmHolder {
       val itemFilmBinding : ItemFilmBinding = DataBindingUtil.inflate(
           LayoutInflater.from(parent.context),
           R.layout.item_film,
           parent,
           false
       )

        return BatmanFilmHolder(itemFilmBinding)
    }

    override fun onBindViewHolder(holder: BatmanFilmHolder, position: Int) {
        bindView(getItem(position), holder)

        holder.itemView.setOnClickListener {
            clickFilm?.onCLickFilm(getItem(position))
        }


    }

    private fun bindView(
        batmanFilm: SearchItem,
        holder: BatmanFilmHolder
    ) {
        Picasso.get()
            .load(batmanFilm.poster)
            .into(holder.bindingInput.imgViewFilmPoster)

        holder.bindingInput.textViewFilmTitle.text = batmanFilm.title

        holder.bindingInput.textViewFilmType.text = batmanFilm.type

        holder.bindingInput.textViewFilmYear.text = batmanFilm.year
    }


    class BatmanFilmHolder(val bindingInput: ItemFilmBinding) :
        RecyclerView.ViewHolder(bindingInput.root) {

    }

    interface OnClickFilm {
        fun onCLickFilm(filmItem : SearchItem)

    }


}