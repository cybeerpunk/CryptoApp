package com.example.cryptoapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Toast
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager

import com.example.cryptoapp.databinding.FragmentListCryptBinding


class ListCryptFragment : Fragment() {

    lateinit var mBinding: FragmentListCryptBinding
    lateinit var mAdapter: ListCryptoAdapter
    private var mListCryptoDTO: List<ListCryptoDTO> = emptyList()
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private lateinit var mParent: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentListCryptBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getListCrypto()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) this.mParent = context
        mParent.mModel.getListCrypto()
    }

    fun setupAdapter() {
        try {
            mLinearLayoutManager = LinearLayoutManager(requireContext())
            mAdapter = ListCryptoAdapter(requireContext(), mListCryptoDTO)
            mBinding.recycleViewListCrypto.layoutManager = mLinearLayoutManager
            mBinding.recycleViewListCrypto.adapter = mAdapter

        } catch (e: Exception) {
            Toast.makeText(requireContext(), e.message.toString(), Toast.LENGTH_SHORT).show()
        }


    }

    fun getListCrypto() {
        mParent.mModel.mListCryptoDTO.observe(viewLifecycleOwner) {
            mListCryptoDTO = it
            setupAdapter()
        }
    }

}