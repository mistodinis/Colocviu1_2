package ro.pub.cs.systems.eim.lab03.phonedialer.view

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import ro.pub.cs.systems.eim.lab03.phonedialer.R
import ro.pub.cs.systems.eim.lab03.phonedialer.general.Constants

class App2 : AppCompatActivity() {
    private var phoneNumberEditText: EditText? = null
    private var callImageButton: ImageButton? = null
    private var hangupImageButton: ImageButton? = null
    private var backspaceImageButton: ImageButton? = null
    private var genericButton: Button? = null
    private var buton: Button? = null
    private var input1: EditText? = null
    private var input2: EditText? = null
    private var op: EditText? = null
    private var result: TextView? = null

    private val callImageButtonClickListener = CallImageButtonClickListener()

    private inner class CallImageButtonClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            if (ContextCompat.checkSelfPermission(
                    this@App2,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@App2,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    Constants.PERMISSION_REQUEST_CALL_PHONE
                )
            } else {
                val intent = Intent(Intent.ACTION_CALL)
                intent.setData(Uri.parse("tel:" + phoneNumberEditText!!.text.toString()))
                startActivity(intent)
            }
        }
    }

    private val hangupImageButtonClickListener = HangupImageButtonClickListener()

    private inner class HangupImageButtonClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            finish()
        }
    }

    private val backspaceButtonClickListener = BackspaceButtonClickListener()

    private inner class BackspaceButtonClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            var phoneNumber = phoneNumberEditText!!.text.toString()
            if (phoneNumber.length > 0) {
                phoneNumber = phoneNumber.substring(0, phoneNumber.length - 1)
                phoneNumberEditText!!.setText(phoneNumber)
            }
        }
    }

    private val genericButtonClickListener = GenericButtonClickListener()

    private inner class GenericButtonClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            val a = input1!!.text.toString().toInt()
            val b = input2!!.text.toString().toInt()
            val op = op!!.text.toString()
            var res = 0
            when (op) {
                "+" -> res = a + b
                "-" -> res = a - b
                "*" -> res = a * b
                "/" -> res = a / b
            }
            result!!.text = res.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_dialer)

        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        input1 = findViewById<View>(R.id.input1) as EditText
        input2 = findViewById<View>(R.id.input2) as EditText
        op = findViewById<View>(R.id.op) as EditText
        buton = findViewById<View>(R.id.buton) as Button
        result = findViewById<View>(R.id.result) as TextView
        buton!!.setOnClickListener(genericButtonClickListener)
//        callImageButton!!.setOnClickListener(callImageButtonClickListener)
//        hangupImageButton = findViewById<View>(R.id.hangup_image_button) as ImageButton
//        hangupImageButton!!.setOnClickListener(hangupImageButtonClickListener)
//        backspaceImageButton = findViewById<View>(R.id.backspace_image_button) as ImageButton
//        backspaceImageButton!!.setOnClickListener(backspaceButtonClickListener)

    }
}

