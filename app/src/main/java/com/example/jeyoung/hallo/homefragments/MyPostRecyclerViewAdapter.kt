package com.example.jeyoung.hallo.homefragments

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.jeyoung.hallo.R


import com.example.jeyoung.hallo.homefragments.FeedFragment.OnListFragmentInteractionListener
import com.example.jeyoung.hallo.dummy.DummyContent.DummyItem

import kotlinx.android.synthetic.main.fragment_post.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyPostRecyclerViewAdapter(
        private val mValues: List<DummyItem>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<MyPostRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        //val mIdView: TextView = mView.item_number
        //val mContentView: TextView = mView.content

        override fun toString(): String {
            return "yay"
        }
    }
}
