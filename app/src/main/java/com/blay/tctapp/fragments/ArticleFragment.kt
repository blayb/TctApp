package com.blay.tctapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blay.tctapp.R
import com.blay.tctapp.adapters.ArticlesAdapter
import com.blay.tctapp.databinding.ArticleFragmetBinding
import com.blay.tctapp.viewmodels.ArticlesViewModel

class ArticleFragment : Fragment() {
    private lateinit var viewModel: ArticlesViewModel

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var _binding: ArticleFragmetBinding? = null

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
        _binding = ArticleFragmetBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.articles.observe(viewLifecycleOwner,  {
            if (it?.articles != null && it.articles.isNotEmpty()) {
                viewManager = LinearLayoutManager(activity)
                viewAdapter = ArticlesAdapter(ArrayList(it.articles))

                binding.recycleView.visibility = View.VISIBLE

                binding.recycleView.apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                }
            } else {
                // show no results text
                binding.recycleView.visibility = View.GONE
                binding.notFoundMessage.visibility =  View.VISIBLE
                binding.notFoundMessage.text = getString(R.string.articles_not_found_text)
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}