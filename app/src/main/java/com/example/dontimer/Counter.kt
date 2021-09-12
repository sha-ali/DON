package com.example.dontimer

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.count.*

class Counter: AppCompatActivity() {
    private  var count:Int? = 0
    private var  counterr:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.count)
        buttonplusonecount.setOnClickListener {
            count = this.count!!.plus(1)
            if(count.toString().length ==1){
                 counterr = "000${count.toString()}"
            }
            else if (count.toString().length == 2){
                counterr = "00${count.toString()}"
            }
            else if (count.toString().length == 3){
                counterr = "0${count.toString()}"
            }else{
                counterr = count.toString()
            }
            textcounting.text = counterr

        }
        buttonreset.setOnClickListener {
            count = 0
            counterr = "000${count.toString()}"
            textcounting.text = counterr
        }
    }
}