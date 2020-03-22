package com.check.coupon.adapter

import android.content.Context
import android.graphics.Color
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import com.check.coupon.R
import com.check.coupon.model.Offer
import com.squareup.picasso.Picasso

/**
 *   OfferView Adapter is the declaration of the recyclerview list item
 *
 */
class OfferViewAdapter(private val mContext: Context, private val mData: List<Offer>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<OfferViewAdapter.MyViewHolder>() {

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View
        val mInflater = LayoutInflater.from(mContext)
        view = mInflater.inflate(R.layout.offerview_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val offerUrl = mData[position].imageUrl
        val offerTitle = mData[position].name
        val offerCashBack = mData[position].cashBack
        val offerCode = mData[position].offerId

        Picasso.get()
            .load(offerUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(holder.offerImage)

        holder.offerTitleText.text = offerTitle
        holder.offerCashBackText.text = "$$offerCashBack"
        holder.offerCashBackText.setTextColor(Color.RED)
    }

    class MyViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        internal var offerImage:ImageView = itemView.findViewById(R.id.offerImage) as ImageView
        internal var offerTitleText:TextView = itemView.findViewById(R.id.offerTitleText) as TextView
        internal var offerCashBackText:TextView = itemView.findViewById(R.id.offerCashBackText) as TextView
    }
}