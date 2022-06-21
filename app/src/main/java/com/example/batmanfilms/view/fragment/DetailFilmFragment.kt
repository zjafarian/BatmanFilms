package com.example.batmanfilms.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.batmanfilms.R
import com.example.batmanfilms.databinding.FragmentDetailFilmBinding
import com.example.batmanfilms.models.ResponseFilm
import com.example.batmanfilms.viewmodel.BatmanViewModel
import com.example.batmanfilms.viewmodel.DetailFilmViewModel
import com.squareup.picasso.Picasso

private const val ARG_IMDB_ID = "ImdbID"


class DetailFilmFragment : Fragment() {

    private lateinit var binding: FragmentDetailFilmBinding

    //define viewModel by lazy
    private val detailFilmVM: DetailFilmViewModel by lazy {
        ViewModelProvider(this).get(DetailFilmViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var imdbID = ""
        arguments?.let {
            imdbID = it.getString(ARG_IMDB_ID, null)
        }

        detailFilmVM.fetchGetDetailOfFilm(imdbID)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_detail_film,
            container,
            false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailFilmVM.detailFilm.observe(viewLifecycleOwner, Observer {
            Log.d("detailBatmanFilm",it.title)

            it?.let { film ->
                binding.film = film
                Picasso.get()
                    .load(film.poster)
                    .into(binding.imageViewPoster)
            }


        })
    }



    companion object {

        @JvmStatic
        fun newInstance(imdbID: String) =
            DetailFilmFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_IMDB_ID, imdbID)
                }
            }
    }
}