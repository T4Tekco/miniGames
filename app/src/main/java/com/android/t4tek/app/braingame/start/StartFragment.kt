package com.android.t4tek.app.braingame.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.t4tek.R
import com.android.t4tek.app.braingame.login.LoginFragment
import com.android.t4tek.app.main.nougat.NougatFragment
import com.android.t4tek.app.main.nougat.NougatViewModel
import com.android.t4tek.databinding.FragmentNougatBinding
import com.android.t4tek.databinding.FragmentStartBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartFragment : Fragment() {

    companion object {
        fun newInstance() = StartFragment()
    }
    private var binding: FragmentStartBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       val view = inflater.inflate(R.layout.fragment_start, container, false)
        val txtNot = view.findViewById<TextView>(R.id.txtNotYou)
        txtNot.setOnClickListener {
            val fragment = LoginFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frm,fragment)?.commit()
        }
        return view
    }

    private fun onclick(){
        binding?.let{
            it.txtNotYou.setOnClickListener {
//                val fragment = LoginFragment()
//                val transaction = fragmentManager?.beginTransaction()
//                    transaction?.replace(R.id.frm,fragment)?.commit()
//                val bundle = bundleOf(
//                    getString(R.string.nav_arg_to_nougat_int) to 1,
//                    getString(R.string.nav_arg_to_nougat_string) to "from Start to Login",
//                )
//                findNavController().navigate(R.id.action_startFragment_to_loginFragment, bundle)
            }
        }
    }
}