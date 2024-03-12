package com.sandhyagill.instalayoutdesign.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandhyagill.instalayoutdesign.R
import com.sandhyagill.instalayoutdesign.adapters.RecyclerHighLightsAdapter
import com.sandhyagill.instalayoutdesign.adapters.RecyclerPostAdapter
import com.sandhyagill.instalayoutdesign.adapters.RecyclerProfilePostAdapter
import com.sandhyagill.instalayoutdesign.adapters.RecyclerStoriesAdapter
import com.sandhyagill.instalayoutdesign.databinding.FragmentAccountBinding
import com.sandhyagill.instalayoutdesign.databinding.FragmentHomeBinding
import com.sandhyagill.instalayoutdesign.modules.HighLights
import com.sandhyagill.instalayoutdesign.modules.Posts
import com.sandhyagill.instalayoutdesign.modules.ProfilePost
import com.sandhyagill.instalayoutdesign.modules.Stories

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentAccountBinding

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
        binding = FragmentAccountBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var highlightslist: MutableList<HighLights> = mutableListOf()
        highlightslist.add(HighLights("Komal",R.drawable.person1))
        highlightslist.add(HighLights("Suman", R.drawable.person2))
        highlightslist.add(HighLights("Tanu", R.drawable.person3))
        highlightslist.add(HighLights("Drishti", R.drawable.person4))
        highlightslist.add(HighLights("Lovi",R.drawable.person5))
        binding.rvHighLights.adapter = RecyclerHighLightsAdapter(highlightslist)
        binding.rvHighLights.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        var profilepostlist: MutableList<ProfilePost> = mutableListOf()
        profilepostlist.add(ProfilePost(R.drawable.person1))
        profilepostlist.add(ProfilePost(R.drawable.person2))
        profilepostlist.add(ProfilePost(R.drawable.person3))
        profilepostlist.add(ProfilePost(R.drawable.person4))
        profilepostlist.add(ProfilePost(R.drawable.person5))

        val layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rvPosts.layoutManager = layoutManager
        val postadapter = RecyclerProfilePostAdapter(profilepostlist)
        binding.rvPosts.adapter = postadapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AccountFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccountFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}