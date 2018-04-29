package com.hydraz.trungnam1992.myapplication.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hydraz.trungnam1992.myapplication.R
import com.hydraz.trungnam1992.myapplication.model.Status

/**
 * Created by trungnam1992 on 4/25/18.
 */
class StatusRecycleAdapter(val mArrayList: ArrayList<Status>) : RecyclerView.Adapter<StatusRecycleAdapter.StatusViewHolder>() {
    var mContext : Context? = null
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): StatusViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        mContext = parent?.context
        return StatusViewHolder(layoutInflater.inflate(R.layout.item_status_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return when {
            mArrayList.isEmpty() -> 0
            else -> mArrayList.size
        }
    }

    override fun onBindViewHolder(holder: StatusViewHolder?, position: Int) {
        holder?.let {
            it.timeTextView.text = mArrayList[position].typeMsg
            it.textViewStatus.text = mArrayList[position].statusMsg

            when (mArrayList[position].typeMsg) {
                Status.SPLIT_MSG -> it.parentLayout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.group_msg_color))
                Status.SINGLE_MSG -> it.parentLayout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.single_msg_color))
            }
        }
    }

    class StatusViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val timeTextView = itemView?.findViewById(R.id.textViewTime) as TextView
        val textViewStatus = itemView?.findViewById(R.id.textViewStatus) as TextView
        val parentLayout = itemView?.findViewById(R.id.parentLayout) as View
    }

}
