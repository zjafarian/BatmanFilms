package com.example.batmanfilms.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.batmanfilms.R

private const val ARG_IMDB_ID = "ImdbID"


class DetailFilmFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_film, container, false)
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