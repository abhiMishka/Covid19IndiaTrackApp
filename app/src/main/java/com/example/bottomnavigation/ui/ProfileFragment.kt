package com.example.bottomnavigation.ui

import android.os.Bundle
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import com.example.bottomnavigation.R
import com.example.bottomnavigation.databinding.FragmentProfileBinding


class ProfileFragment : BaseFragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onDataRefreshed() {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        activity?.title = getString(R.string.title_information)
        binding.sourceTextValue.text = HtmlCompat.fromHtml(resources.getString(R.string.source_dilaog_text), FROM_HTML_MODE_LEGACY)
        binding.sourceTextValue.movementMethod = LinkMovementMethod.getInstance()
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