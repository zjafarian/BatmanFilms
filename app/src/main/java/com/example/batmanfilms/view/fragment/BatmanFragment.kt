package com.example.batmanfilms.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.batmanfilms.R
import com.example.batmanfilms.adapters.BatmanFilmsAdapter
import com.example.batmanfilms.databinding.FragmentBatmanBinding
import com.example.batmanfilms.models.SearchItem
import com.example.batmanfilms.view.activity.DetailFilmActivity
import com.example.batmanfilms.viewmodel.BatmanViewModel


class BatmanFragment : Fragment() {

    private lateinit var binding: FragmentBatmanBinding
    private var batmanAdapter: BatmanFilmsAdapter? = null

    //define viewModel by lazy
    private val batmanVM: BatmanViewModel by lazy {
        ViewModelProvider(this).get(BatmanViewModel::class.java)
    }


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
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_batman,
            container,
            false
        )

        //initial adapter
        initAdapter()

        //initial recyclerView
        initRecyclerView()

        //set listener
        listener()


        return binding.root
    }

    //this function is view's listeners
    private fun listener() {

        //when user clicks on a film in list, this listener will active
        batmanAdapter?.onClickFilm(object : BatmanFilmsAdapter.OnClickFilm {
            override fun onCLickFilm(filmItem: SearchItem) {

                filmItem.imdbID?.let { imdbId ->

                    //create intent from DetailFilmActivity with imdbId and start it
                    val intent = DetailFilmActivity.newIntent(requireContext(),imdbId)
                    startActivity(intent)
                }



            }

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //call observers
        setObservers()
    }

    //initial recyclerView
    private fun initRecyclerView() {
        binding.recyclerViewBatmanFilms.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerViewBatmanFilms.adapter = batmanAdapter
    }

    //initial adapter
    private fun initAdapter() {
        batmanAdapter = BatmanFilmsAdapter()
    }

    //this function listens to observables
    private fun setObservers() {

        //this observer listen to list of batman films
        batmanVM.batmanFilms.observe(viewLifecycleOwner, Observer {

            //set arrayList in adapter
            batmanAdapter?.submitList(it)
        })
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            BatmanFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}