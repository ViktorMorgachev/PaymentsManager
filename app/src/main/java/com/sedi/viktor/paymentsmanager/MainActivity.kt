package com.sedi.viktor.paymentsmanager

import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sedi.viktor.paymentsmanager.brodcasts.SMSMonitor
import com.sedi.viktor.paymentsmanager.interfaces.IPayments
import com.sedi.viktor.paymentsmanager.ui.FragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val br: BroadcastReceiver = SMSMonitor()
    private val payments: IPayments? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        registerBroadcastReceiver();
    }

    private fun init() {
        supportActionBar?.elevation = 0f
        var icons = arrayListOf<Drawable>(
            resources.getDrawable(R.drawable.ic_android),
            resources.getDrawable(R.drawable.ic_email)
        )
        viewPager.adapter = FragmentAdapter(this).apply {
            setIcons(icons)
        }
        TabLayoutMediator(
            tabLayout,
            viewPager,
            TabLayoutMediator.TabConfigurationStrategy() { tab: TabLayout.Tab, position: Int ->
                tab.icon = icons[position]
            }).attach()

    }


    override fun onDestroy() {
        unregisterReceiver(br)
        super.onDestroy()
    }

    private fun registerBroadcastReceiver() {
        var filter = IntentFilter().apply {
            addAction(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)
        }
        registerReceiver(br, filter)
    }
}