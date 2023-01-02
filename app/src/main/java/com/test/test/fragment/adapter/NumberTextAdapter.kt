package com.test.test.fragment.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.test.R
import com.test.test.bd.DbNumber


class NumberTextAdapter(private val versionList: MutableList<DbNumber>) : RecyclerView.Adapter<NumberTextAdapter.ViewHolder>() {
    private var onClickListener: OnClickListener?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_number_text, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(versionList[position])
        holder.itemView.setOnClickListener {
            if(onClickListener!=null){
                onClickListener!!.onClick(position)
            }
        }

    }

    override fun getItemCount(): Int {
        return versionList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(numberMessageText: DbNumber) {
            val textViewNum = itemView.findViewById<TextView>(R.id.textViewNum)
            val textViewTextText = itemView.findViewById<TextView>(R.id.textViewText)
            textViewNum.text=numberMessageText.number.toString()
            textViewTextText.text=numberMessageText.numberText.toString()

        }

    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener=onClickListener
    }



    interface OnClickListener{
        fun onClick(position: Int)
    }

}