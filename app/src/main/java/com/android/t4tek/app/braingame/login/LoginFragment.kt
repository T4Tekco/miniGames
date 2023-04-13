package com.android.t4tek.app.braingame.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.android.t4tek.R
import com.android.t4tek.app.braingame.signup.SignUpFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val txtSign = view.findViewById<TextView>(R.id.txtSignUp)
        val txtFot = view.findViewById<TextView>(R.id.txtFotgot)
        txtSign.setOnClickListener {
            val fragment = SignUpFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frm,fragment)?.commit()
        }
        txtFot.setOnClickListener {
            val fragment = ChangePassFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frm,fragment)?.commit()
        }
        return view
    }

}