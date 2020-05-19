package com.wyao.coolweatherjetpack.ui.area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.wyao.coolweatherjetpack.R
import com.wyao.coolweatherjetpack.data.PlaceRepository
import com.wyao.coolweatherjetpack.databinding.ChooseAreaBindingImpl

class ChooseAreaFragment: Fragment() {

    //TODO: display a list of are name
    private val mViewModel by lazy { ViewModelProvider(this, ChooseAreaModelFactory(PlaceRepository())).get(ChooseAreaViewModel::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.choose_area, container, false)
        val binding = DataBindingUtil.bind<ChooseAreaBindingImpl>(view)
        binding?.viewModel = mViewModel
        return view
    }
}