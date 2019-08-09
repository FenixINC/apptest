package com.taras.apptest.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.taras.apptest.BR
import com.taras.apptest.R
import com.taras.apptest.data.models.Comment
import com.taras.apptest.databinding.FragmentCommentsBinding

class CommentsFragment : Fragment() {

    private lateinit var mBinding: FragmentCommentsBinding
    private lateinit var mAdapter: CommentsAdapter

    companion object {
        fun newInstance() = CommentsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentCommentsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onStop() {
        super.onStop()
        activity?.finish()
    }

    //------ Adapter:
    private class CommentsAdapter : RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {

        private var mList: ArrayList<Comment> = ArrayList()

        fun setList(list: List<Comment>) {
            mList.clear()
            mList.addAll(list)
            notifyDataSetChanged()
        }

        fun getItem(position: Int): Comment = mList[position]

        fun getList(): List<Comment> = mList

        override fun getItemCount(): Int = mList.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val holder: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.item_comment, parent, false)
            return ViewHolder(holder)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(getItem(position))
        }

        class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(data: Any) {
                binding.setVariable(BR.model, data)
            }
        }
    }
}