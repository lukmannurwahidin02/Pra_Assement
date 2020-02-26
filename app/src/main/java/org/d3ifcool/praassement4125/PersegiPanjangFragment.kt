package org.d3ifcool.praassement4125

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi_panjang.*
import org.d3ifcool.praassement4125.databinding.FragmentPersegiPanjangBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class PersegiPanjangFragment : Fragment() {

    var luas = 0
    var keliling = 0
    private lateinit var binding: FragmentPersegiPanjangBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentPersegiPanjangBinding>(inflater,
            R.layout.fragment_persegi_panjang,container,false)

        binding.buttonHitungPP.setOnClickListener {
            if (isEmpty()){
                binding.textViewLuasHasilPP.text = "Silakan Isi Semua Form"
            }
            else{
                hitung(editTextPanjangPP.text.toString().toInt(),editTextLebarPP.text.toString().toInt())
            }
        }
        if (savedInstanceState != null){
            luas = savedInstanceState.getInt("key_luas")
            keliling = savedInstanceState.getInt("key_keliling")

            binding.textViewLuasHasilPP.text = luas.toString()
            binding.textViewKelilingHasilPP.text = keliling.toString()
        }

        return binding.root
    }
    private fun isEmpty(): Boolean{
        if(editTextPanjangPP.text.isEmpty() || editTextLebarPP.text.isEmpty()){
            return true
        }
        return false
    }

    private fun hitung(panjang : Int, lebar: Int){
        luas = panjang * lebar
        keliling = (2*panjang) + (2*lebar)

        binding.textViewLuasHasilPP.text = luas.toString()
        binding.textViewKelilingHasilPP.text = keliling.toString()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("key_luas",luas)
        outState.putInt("key_keliling",keliling)
        super.onSaveInstanceState(outState)
    }

}
