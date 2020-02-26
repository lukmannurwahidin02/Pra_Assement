package org.d3ifcool.praassement4125


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3ifcool.praassement4125.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater, R.layout.fragment_main, container, false)

        binding.buttonPersegiPanjang.setOnClickListener { v:View ->
            v.findNavController().navigate(R.id.action_mainFragment_to_persegiPanjangFragment)
        }
        binding.buttonSegitiga.setOnClickListener { v:View ->
            v.findNavController().navigate(R.id.action_mainFragment_to_segitigaFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            view!!.findNavController()) || super.onOptionsItemSelected(item)
    }

}
