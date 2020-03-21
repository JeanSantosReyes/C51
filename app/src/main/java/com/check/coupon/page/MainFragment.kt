package com.check.coupon.page

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.check.coupon.R
import com.check.coupon.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        LoginTextButton.setOnClickListener{
            viewModel.initializeRepository()
            loginProgressBar.visibility = View.VISIBLE
        }

        viewModel.appReady.observe(viewLifecycleOwner, Observer {
            if(it) {
                Navigation.findNavController(this.view!!)
                    .navigate(R.id.action_mainFragment_to_hubFragment)
            }
        })
    }



}
