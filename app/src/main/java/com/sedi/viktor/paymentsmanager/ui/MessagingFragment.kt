package com.sedi.viktor.paymentsmanager.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sedi.viktor.paymentsmanager.R
import com.sedi.viktor.paymentsmanager.interfaces.IPayments
import com.sedi.viktor.paymentsmanager.storage.FakePaymentsManager
import com.sedi.viktor.paymentsmanager.ui.presenters.MessagesAdapter
import kotlinx.android.synthetic.main.messages_fragment.*

class MessagingFragment private constructor() : Fragment() {


    companion object {
        private val messagingFragment: MessagingFragment = MessagingFragment()
        fun newInstance() = messagingFragment
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.messages_fragment, container, false)
        return view
    }

    override fun onResume() {
        super.onResume()
        initUI()
    }

    private fun initUI() {
        val paymentsManager: IPayments = FakePaymentsManager.Instance()
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        var data = context?.let { paymentsManager.getAllMessages(it) }
        recyclerView.adapter = data?.let { MessagesAdapter(it) }
        recyclerView.layoutParams = layoutParams
    }
}