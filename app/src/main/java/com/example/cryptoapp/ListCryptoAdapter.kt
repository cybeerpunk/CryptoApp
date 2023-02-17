package com.example.cryptoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.databinding.RecyclerViewListCryptoBinding

class ListCryptoAdapter ( val mContext: Context, val aListCrypto: List<ListCryptoDTO>) :
    RecyclerView.Adapter<ListCryptoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCryptoViewHolder {
        val lBinding =
            RecyclerViewListCryptoBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return ListCryptoViewHolder(lBinding, mContext)
    }

    override fun onBindViewHolder(holder: ListCryptoViewHolder, position: Int) {
        holder.fill(aListCrypto[position])
    }

    override fun getItemCount(): Int {
        return aListCrypto.size

    }


    override fun getItemViewType(position: Int): Int {
        return position
    }
}