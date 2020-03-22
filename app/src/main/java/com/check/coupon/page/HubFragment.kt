package com.check.coupon.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.check.coupon.R
import com.check.coupon.adapter.OfferViewAdapter
import com.check.coupon.model.Offer
import com.check.coupon.viewmodel.HubViewModel
import kotlinx.android.synthetic.main.hub_fragment.*
import kotlinx.android.synthetic.main.offerview_item.view.*


class HubFragment : Fragment() {

    companion object {
        fun newInstance() = HubFragment()
    }
    private lateinit var viewModel: HubViewModel
    private lateinit var offers: ArrayList<Offer>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        offers = ArrayList()
        return inflater.inflate(R.layout.hub_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HubViewModel::class.java)
        // TODO: Use the ViewModel
        // RecyclerView declaration
        offerItemList.apply {
            adapter = OfferViewAdapter(context, offers)
        }
        viewModel.getOfferList()
        offerItemList.layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 2)
        offerItemList.setHasFixedSize(true)

        offerItemList.addOnItemTouchListener(
            OfferViewAdapter.RecyclerTouchListener(
                this.requireContext(),
                object :
                    OfferViewAdapter.ClickListener {
                    override fun onClick(view: View, position: Int) {
                       // var offerList = viewModel.getOfferList() as ArrayList<Offer>
                        val bundle = bundleOf("offer_id" to view.offerId.text.toString())
                       Navigation.findNavController(requireView()).
                            navigate(R.id.action_hubFragment_to_offerFragment,bundle)
                    }
                }
            )
        )
        // observe the offer list from the view model
        viewModel.offerList.observe(viewLifecycleOwner, Observer {
            it.forEach { it ->
                offers.add(it)
            }
            if(it.isNotEmpty()) {
                offerItemList.adapter?.notifyDataSetChanged()
            } else {
                offerItemList.visibility = View.GONE
                errorText.visibility = View.VISIBLE
            }
        })
        // check the internet or data of the device and provide a toast warning message to the user
        if(!viewModel.isNetworkAvailable(requireContext())) {
            Toast.makeText(requireContext(),"Internet not available,Loading from Cache",Toast.LENGTH_LONG).show()
        }
    }
}