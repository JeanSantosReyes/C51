package com.check.coupon.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.check.coupon.R
import com.check.coupon.model.Offer
import com.squareup.picasso.Picasso


/**
 *
 *
 *   OfferView Adapter is the declaration of the recyclerview list item
 *
 */
class OfferViewAdapter(private val mContext: Context, private val mData: List<Offer>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<OfferViewAdapter.OfferViewHolder>() {

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val view: View
        val mInflater = LayoutInflater.from(mContext)
        view = mInflater.inflate(R.layout.offerview_item, parent, false)
        return OfferViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        val offerUrl = mData[position].imageUrl
        val offerTitle = mData[position].name
        val offerCashBack = mData[position].cashBack

        Picasso.get()
            .load(offerUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(holder.offerImage)

        holder.offerTitleText.text = offerTitle
        holder.offerCashBackText.text = "$$offerCashBack"
        holder.offerCashBackText.setTextColor(Color.RED)
    }

    class OfferViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        internal var offerImage:ImageView = itemView.findViewById(R.id.offerImage) as ImageView
        internal var offerTitleText:TextView = itemView.findViewById(R.id.offerTitleText) as TextView
        internal var offerCashBackText:TextView = itemView.findViewById(R.id.offerCashBackText) as TextView
    }
}