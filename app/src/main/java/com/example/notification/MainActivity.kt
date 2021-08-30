package com.example.notification

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var notificationManager:NotificationManager
    lateinit var builder:Notification.Builder
    lateinit var notificationchannel:NotificationChannel
    var channerid="com.example.notification"
    var des="harrystark"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager=getSystemService(Context.NOTIFICATION_SERVICE)  as NotificationManager
        button.setOnClickListener {
            val intent= Intent(this,LauncherActivity::class.java)
            val pendingintent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationchannel= NotificationChannel(channerid,des,NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(notificationchannel)
                builder=Notification.Builder(this,channerid)
                    .setContentTitle("haa")
                    .setContentText("hehe")
                    .setSmallIcon(R.drawable.ic_launcher_round)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_launcher))
                    .setContentIntent(pendingintent)

            }else{
                builder=Notification.Builder(this)
                    .setContentTitle("haa")
                    .setContentText("hehe")
                    .setSmallIcon(R.drawable.ic_launcher_round)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_launcher))
                    .setContentIntent(pendingintent)
            }
            notificationManager.notify(1234,builder.build())
        }
    }
}