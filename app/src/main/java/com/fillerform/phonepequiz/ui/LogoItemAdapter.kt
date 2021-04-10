package com.fillerform.phonepequiz.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fillerform.phonepequiz.databinding.AdapterLogoItemBinding
import com.fillerform.phonepequiz.repo.model.Logo

class LogoItemAdapter : RecyclerView.Adapter<LogoItemAdapter.ViewHolder>() {

    private val items = ArrayList<Logo>()

    fun setItems(logoList: List<Logo>) {
        items.clear()
        items.addAll(logoList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binder =
            AdapterLogoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewModel = LogoItemViewModel()
        holder.binder.vm = viewModel
        viewModel.setLogo(items[position])
    }

    override fun getItemCount() = items.size

    class ViewHolder(val binder: AdapterLogoItemBinding) : RecyclerView.ViewHolder(binder.root) {

    }

}


