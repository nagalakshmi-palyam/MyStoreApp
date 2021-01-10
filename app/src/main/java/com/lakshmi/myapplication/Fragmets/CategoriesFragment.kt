package com.lakshmi.myapplication.Fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.lakshmi.myapplication.DatabaseForCollectionFragment.Collection
import com.lakshmi.myapplication.DatabaseForCollectionFragment.CollectionAdapter
import com.lakshmi.myapplication.DatabaseForCollectionFragment.CollectionViewModel
import com.lakshmi.myapplication.DatabaseForCollectionFragment.CollectionViewModelFactory
import com.lakshmi.myapplication.Listners.CollectionItemClickListener
import com.lakshmi.myapplication.R
import kotlinx.android.synthetic.main.activity_next_collection.*
import kotlinx.android.synthetic.main.fragment_categories.*

class CategoriesFragment : Fragment(),CollectionItemClickListener{
    private var list = emptyList<Collection>()
    private lateinit var collectionViewModel: CollectionViewModel
    private lateinit var collectionAdapter: CollectionAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectionViewModel= CollectionViewModelFactory(requireContext()).create(CollectionViewModel::class.java)
        setAdapterandLayout()
        fetchfromDatabase()
    }
    fun setAdapterandLayout(){
        val linearlayoutmanager = LinearLayoutManager(context)
        collectionAdapter= CollectionAdapter(list,this)
        recyclercollectionfragment.apply {
            this.layoutManager = linearlayoutmanager
            this.adapter=collectionAdapter
        }
    }
    fun fetchfromDatabase(){
        collectionViewModel.fetchDataFromDB().observe(this,{
            it.let{
                this.list=it
                collectionAdapter.updateList(it)
                for(i in 0 until it.size) {
                }
            }
        })

    }

    override fun onItemClicked(itemModel: Collection, Position: Int) {
        TODO("Not yet implemented")
    }

}