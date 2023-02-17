package com.example.cryptoapp


import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView

import com.example.cryptoapp.databinding.RecyclerViewListCryptoBinding

class ListCryptoViewHolder(
    private val mBinding: RecyclerViewListCryptoBinding,
    val mContext: Context
) : RecyclerView.ViewHolder(mBinding.root) {

    fun fill(aDTO: ListCryptoDTO) {
        mBinding.textViewId.text = aDTO.id
        mBinding.textViewName.text = aDTO.name
        mBinding.textViewSymbol.text = aDTO.symbol
        setClickCrypto(aDTO)

    }

    fun setClickCrypto (aDTO: ListCryptoDTO){
      mBinding.cardViewCrypto.setOnClickListener {
          val lIntent = Intent(mContext, DetalhesCryptoActivity::class.java)
          lIntent.putExtra("IdCrypto", aDTO.id)
          mContext.startActivity(lIntent)
      }
    }

}