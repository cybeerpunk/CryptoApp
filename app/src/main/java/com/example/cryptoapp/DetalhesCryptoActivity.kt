package com.example.cryptoapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.api.ListCryptoRepository
import com.example.cryptoapp.databinding.ActivityDetalhesCryptoBinding



class DetalhesCryptoActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityDetalhesCryptoBinding
    lateinit var mModel: CryptoViewModel
    lateinit var mDTO: DetalhesCryptoDTO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDetalhesCryptoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mModel = ViewModelProvider(
            this,
            CryptoViewModelFactory(ListCryptoRepository())
        )[CryptoViewModel::class.java]

        getIntentCrypto()
        getDetalhes()
        closeDetalhes()
        catchErrorMessege()
    }

    private fun getIntentCrypto() {
        if (intent.hasExtra("IdCrypto")) {
            val lIdCrypto = intent.extras!!.getString("IdCrypto")
            mModel.getDetalhesCrypto(lIdCrypto!!)

        }
    }

    private fun getDetalhes() {
        mModel.mDetalhesCryptoDTO.observe(this) {
            if (it == null) {
                Toast.makeText(this, "Sua requisição não foi processada!", Toast.LENGTH_SHORT).show()

            } else {
                mDTO = it
                fill(mDTO)
            }
        }
    }

    private fun fill (aDTO: DetalhesCryptoDTO){
        mBinding.textViewIdDetalhes.text = "Id: " + aDTO.id
        mBinding.textViewNameDetalhes.text = "Name: " + aDTO.name
        mBinding.textViewSymbolDetalhes.text = "Symbol: " + aDTO.symbol
        mBinding.textViewPlataformaId.text = "Plataforma ID: " + aDTO.asset_platform_id
        mBinding.textViewLastUpdate.text = "Last Update: " + aDTO.last_updated

    }
    private fun closeDetalhes(){
        mBinding.imageViewClose.setOnClickListener{
            finish()
        }
    }
    private fun catchErrorMessege(){
        mModel.mResponse.observe(this){
            Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
        }
    }
}