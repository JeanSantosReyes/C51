package com.check.coupon.page

import android.content.Intent
import android.graphics.Color
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

import com.check.coupon.R
import com.check.coupon.repository.CouponRepository
import com.check.coupon.viewmodel.OfferViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.offer_fragment.*
import kotlinx.android.synthetic.main.offerview_item.*

class OfferFragment : Fragment() {

    companion object {
        fun newInstance() = OfferFragment()
    }

    private lateinit var viewModel: OfferViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.offer_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OfferViewModel::class.java)
        val selectedOffer = viewModel.findOfferById(arguments?.get("offer_id").toString())
        val offerImage: ImageView = offerImageView as ImageView
        Picasso.get()
            .load(selectedOffer.imageUrl.toString())
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(offerImage)
        offerTitleDetailText.text = selectedOffer.name
        offerCashBackDetailText.text = "$" + (selectedOffer.cashBack.toString())
        offerIdDetailText.text = selectedOffer.offerId

        offerShareButton.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, selectedOffer.imageUrl.toString()
                  + "\n" + selectedOffer.name
                  + "\n" + "$" + (selectedOffer.cashBack.toString())
                  + "\n" + selectedOffer.offerId)
            startActivity(Intent.createChooser(shareIntent,"Share via"))
        }
    }
}