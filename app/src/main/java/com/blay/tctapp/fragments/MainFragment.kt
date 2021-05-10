package com.blay.tctapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.blay.tctapp.R
import com.blay.tctapp.databinding.MainFragmentBinding
import com.blay.tctapp.viewmodels.ArticlesViewModel

class MainFragment : Fragment() {
    private lateinit var viewModel: ArticlesViewModel

    private var _binding: MainFragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ArticlesViewModel::class.java)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.button.setOnClickListener {
            //call to get articles data
            viewModel.getData()

            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.container, ArticleFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}