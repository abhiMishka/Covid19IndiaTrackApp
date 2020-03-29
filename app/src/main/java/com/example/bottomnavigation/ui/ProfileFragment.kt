package com.example.bottomnavigation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.R
import com.example.bottomnavigation.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        activity?.title = getString(R.string.title_information)
        setClickListeners()
        return binding.root
    }
    private fun setClickListeners(){
        binding.usefullLinkTv.setOnClickListener {
            if(binding.usefullLinkListLl.visibility == View.VISIBLE){
                binding.usefullLinkListLl.visibility = View.GONE
            }else{
                binding.usefullLinkListLl.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        val TAG: String = ProfileFragment::class.java.simpleName
        fun newInstance() = ProfileFragment()
    }

}