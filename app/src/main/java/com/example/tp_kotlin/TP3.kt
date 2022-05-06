package com.example.tp_kotlin

import android.app.Activity
import android.app.PendingIntent
import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.telephony.SmsManager
import android.text.TextUtils
import android.text.style.BackgroundColorSpan
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.graphics.green
import androidx.core.graphics.toColorInt
import com.example.tp_kotlin.R.menu.menu
import java.text.SimpleDateFormat
import java.util.*
import java.util.jar.Manifest

class TP3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tp3)
        val btn = findViewById<Button>(R.id.btn)
      val text =   findViewById<TextView>(R.id.textView)
        text.text= " COMPTE-RENDU" + " AMIR MANSOUR " + " & " + " LINA KHATAT " + " & "+" AMENI RJAB"
        text.setSingleLine()
        text.ellipsize= TextUtils.TruncateAt.MARQUEE
        text.marqueeRepeatLimit= -1
        text.isSelected=true
        btn.setOnClickListener {

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 100);
            //  uploadImag();


        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {

            R.id.appels_normal -> {
                if (ActivityCompat.checkSelfPermission(
                        this@TP3,
                        android.Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    requestPermissionscall()
                } else {
                    call()
                }

            }
            R.id.sms_normal -> {
                if (ActivityCompat.checkSelfPermission(
                        this@TP3,
                        android.Manifest.permission.SEND_SMS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    requestPermissionssms()
                } else {
                    sms()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun requestPermissionscall() {
        ActivityCompat.requestPermissions(
            this@TP3,
            arrayOf(android.Manifest.permission.CALL_PHONE),
            1
        )
    }


    private fun sms() {
        Toast.makeText(this@TP3, "sms send", Toast.LENGTH_LONG).show()
        val num = "27069149"
        val msg = "amir mannsouri"
        val intent = Intent(Intent.ACTION_SENDTO)

        intent.data = Uri.parse("smsto:$num?body=$msg")
        startActivity(intent)
        //  val smsManager: PendingIntent = PendingIntent.getBroadcast(this, 0, Intent("SMS_SENT"), 0)
//        val smsManager: SmsManager = SmsManager.getDefault()
//        smsManager.sendTextMessage(num, null, msg, null, null)
    }

    private fun requestPermissionssms() {
        ActivityCompat.requestPermissions(
            this@TP3,
            arrayOf(android.Manifest.permission.SEND_SMS),
            1
        )
    }

    private fun call() {
        val intent = Intent(Intent.ACTION_CALL)
        val num = "27069149"
        intent.data = Uri.parse("tel:$num")
        startActivity(intent)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            val takeimage = data?.extras?.get("data") as Bitmap
            val image = findViewById<ImageView>(R.id.image)
            image.setImageBitmap(takeimage)

        } else {

        }
    }


}


