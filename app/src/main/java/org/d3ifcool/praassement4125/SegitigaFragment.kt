package org.d3ifcool.praassement4125

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_segitiga.*
import org.d3ifcool.praassement4125.databinding.FragmentSegitigaBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class SegitigaFragment : Fragment() {
    var luas: Double = 0.0
    var keliling: Double = 0.0
    private lateinit var binding: FragmentSegitigaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentSegitigaBinding>(inflater,
            R.layout.fragment_segitiga,container,false)
        if (savedInstanceState != null){
            luas = savedInstanceState.getDouble("key_luas")
            keliling = savedInstanceState.getDouble("key_keliling")

            binding.textViewHasilLuasS.text = luas.toString()
            binding.textViewHasilKelilingS.text = keliling.toString()
        }
        binding.buttonHitungSegitiga.setOnClickListener {
            if (isEmpty()){
                binding.textViewHasilLuasS.text = "Silakan Isi Semua Form"
            }
            else{
                hitung(editTextAlas.text.toString().toDouble(),editTextTinggi.text.toString().toDouble())
            }
        }

        return binding.root
    }

    private fun hitung(alas : Double, tinggi: Double){
        luas = (alas/2) * tinggi

        keliling = alas + tinggi + (Math.hypot(alas,tinggi))

        binding.textViewHasilLuasS.text = luas.toString()
        binding.textViewHasilKelilingS.text = keliling.toString()

    }

    private fun isEmpty(): Boolean{
        if(editTextAlas.text.isEmpty() || editTextTinggi.text.isEmpty()){
            return true
        }
        return false
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("key_luas",luas)
        outState.putDouble("key_keliling",keliling)
        super.onSaveInstanceState(outState)
    }
}
