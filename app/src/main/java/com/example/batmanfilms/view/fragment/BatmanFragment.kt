package com.example.batmanfilms.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batmanfilms.R
import com.example.batmanfilms.adapters.BatmanFilmsAdapter
import com.example.batmanfilms.databinding.FragmentBatmanBinding
import com.example.batmanfilms.viewmodel.BatmanViewModel


class BatmanFragment : Fragment() {

    private lateinit var binding: FragmentBatmanBinding
    private var batmanAdapter: BatmanFilmsAdapter? = null

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

        setupAdapter()
        initRecyclerView()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
    }

    private fun initRecyclerView() {
        binding.recyclerViewBatmanFilms.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerViewBatmanFilms.adapter = batmanAdapter
    }

    private fun setupAdapter() {
        batmanAdapter = BatmanFilmsAdapter()
    }

    private fun setObservers(){
        batmanVM.batmanFilms.observe(viewLifecycleOwner, Observer {
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