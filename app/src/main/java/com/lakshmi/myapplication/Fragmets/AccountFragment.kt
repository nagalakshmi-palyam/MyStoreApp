package com.lakshmi.myapplication.Fragmets

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lakshmi.myapplication.Activities.HomeActivity
import com.lakshmi.myapplication.Activities.VideoActivity
import com.lakshmi.myapplication.R
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }
    fun initViews(view:View){
     cardvideo.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
       when(v?.id){
           R.id.cardvideo->{
//               val intent = Intent(requireContext(), VideoActivity::class.java)
//               startActivity(intent)
               val helpline = HelpLineFragment()
               val bundle = Bundle()
               activity?.let {
                   it.supportFragmentManager.beginTransaction().replace(R.id.fragment_Container,helpline).commit()
               }
           }
       }
    }
}