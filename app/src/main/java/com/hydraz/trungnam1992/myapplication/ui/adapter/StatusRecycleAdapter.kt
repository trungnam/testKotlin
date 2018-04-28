package com.hydraz.trungnam1992.myapplication.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hydraz.trungnam1992.myapplication.R
import com.hydraz.trungnam1992.myapplication.R.id.textViewTime
import com.hydraz.trungnam1992.myapplication.model.Status

/**
 * Created by trungnam1992 on 4/25/18.
 */
class StatusRecycleAdapter(val mArrayList : ArrayList<Status>) : RecyclerView.Adapter<StatusRecycleAdapter.StatusViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): StatusViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        return StatusViewHolder(layoutInflater.inflate(R.layout.item_status_layout, parent, false))    }

    override fun getItemCount(): Int {
        when {
            mArrayList.isEmpty() -> return 0
            else -> return mArrayList.size
        }
    }

    override fun onBindViewHolder(holder: StatusViewHolder?, position: Int) {
        holder?.let{
            it.timeTextView.text = ""
            it.textViewStatus.text = mArrayList[position].statusMsg
            when(mArrayList[position].typeMsg){
                Status.SPLIT_MSG -> it.viewSplitMsg.visibility = View.VISIBLE
                Status.SINGLE_MSG -> it.viewSplitMsg.visibility = View.GONE
            }
        }
    }


    class StatusViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val timeTextView = itemView?.findViewById(R.id.textViewTime) as TextView
        val textViewStatus = itemView?.findViewById(R.id.textViewStatus) as TextView
        val viewSplitMsg = itemView?.findViewById(R.id.viewSplitMsg) as View
    }

}
