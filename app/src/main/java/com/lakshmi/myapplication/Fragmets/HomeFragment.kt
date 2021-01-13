package com.lakshmi.myapplication.Fragmets

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.lakshmi.myapplication.R
import com.lakshmi.myapplication.RoomDatabse.ProductViewModel
import com.lakshmi.myapplication.RoomDatabse.ProductViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),View.OnClickListener {
    private lateinit var productViewModel: ProductViewModel
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
        productViewModel= ProductViewModelFactory(this.requireContext()).create(ProductViewModel::class.java)
        lifetimeSpinnerandotherviews(view)
    }
    fun lifetimeSpinnerandotherviews(view:View){
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
        fetchfromDatabase()
        btnshare.setOnClickListener(this)

    }
    fun fetchfromDatabase(){
        productViewModel.fetchDataFromDB().observe(this, {
            it.let {
              productcount.text=it.size.toString()
            }
        })

    }

    override fun onClick(v: View?) {
        when(v?.id){
          R.id.btnshare->{
              val intent= Intent(Intent.ACTION_SEND)
              intent.setType("text/plain")
              var sharebody="Download the App now:https://play.google.com/store/apps/details?id=com.khatabook.dukaan"
              var sharesub="MyDukan"
              intent.putExtra(Intent.EXTRA_SUBJECT,sharesub)
              intent.putExtra(Intent.EXTRA_SUBJECT,sharebody)
              startActivity(Intent.createChooser(intent,"Share Using"))
          }
        }
    }

}