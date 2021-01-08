package com.lakshmi.myapplication.Fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.lakshmi.myapplication.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifetimeSpinner(view)
    }
    fun lifetimeSpinner(view:View){
        var list:MutableList<String> = mutableListOf<String>()
        list.add("Life Time")
        list.add("Today")
        list.add("Yesterday")
        val spinner = view.findViewById<Spinner>(R.id.timeSpinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this.requireContext(),
                android.R.layout.simple_spinner_item, list
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
//                    Toast.makeText(
//                        this@AddProduct,
//                         collection+ " " +
//                                "" + category[position], Toast.LENGTH_SHORT
//                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

    }

}