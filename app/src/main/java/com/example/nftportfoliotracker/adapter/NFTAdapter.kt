package com.example.nftportfoliotracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.nftportfoliotracker.R
import com.example.nftportfoliotracker.model.MainResponse
import com.example.nftportfoliotracker.model.Nft
import kotlinx.android.synthetic.main.nft_list_item.view.*

class NFTAdapter(
    var mainModel: List<Nft>
) :
    RecyclerView.Adapter<NFTAdapter.ViewHolder>() {

    inner class ViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ) : RecyclerView.ViewHolder(
        inflater.inflate(
            R.layout.nft_list_item,
            parent,
            false
        )
    ) {

        fun setData(nftDetails: Nft?) {
            itemView.apply {
                tv_contract.text = "CONTRACT:   " + nftDetails?.contract_address
                tv_name.text = "NAME:   " + nftDetails?.name
                tv_creator.text = "CREATOR:   " + nftDetails?.creator_address

                Glide.with(context)
                    .load(nftDetails?.cached_file_url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(mainModel[position])
    }

    override fun getItemCount(): Int {
        return mainModel.size
    }

    fun setNftList(mainModel: List<Nft>) {
        this.mainModel = mainModel
        notifyDataSetChanged()
    }
}