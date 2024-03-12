package com.sandhyagill.instalayoutdesign.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandhyagill.instalayoutdesign.R
import com.sandhyagill.instalayoutdesign.adapters.RecyclerPostAdapter
import com.sandhyagill.instalayoutdesign.adapters.RecyclerStoriesAdapter
import com.sandhyagill.instalayoutdesign.databinding.FragmentHomeBinding
import com.sandhyagill.instalayoutdesign.modules.Posts
import com.sandhyagill.instalayoutdesign.modules.Stories

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var storieslist: MutableList<Stories> = mutableListOf()
        storieslist.add(Stories("Komal",R.drawable.person1))
        storieslist.add(Stories("Suman", R.drawable.person2))
        storieslist.add(Stories("Tanu", R.drawable.person3))
        storieslist.add(Stories("Drishti", R.drawable.person4))
        storieslist.add(Stories("Lovi",R.drawable.person5))
        binding.rvStories.adapter = RecyclerStoriesAdapter(storieslist)
        binding.rvStories.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        var postlist: MutableList<Posts> = mutableListOf()
        postlist.add(Posts("Komal",R.drawable.person1,R.drawable.person1))
        postlist.add(Posts("Suman", R.drawable.person2,R.drawable.person2))
        postlist.add(Posts("Tanu", R.drawable.person3,R.drawable.person3))
        postlist.add(Posts("Drishti", R.drawable.person4,R.drawable.person4))
        postlist.add(Posts("Lovi",R.drawable.person5,R.drawable.person5))
        binding.rvPosts.adapter = RecyclerPostAdapter(postlist)
        binding.rvPosts.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}