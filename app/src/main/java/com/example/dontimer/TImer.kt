package com.example.dontimer

import android.media.MediaPlayer
import android.opengl.Visibility
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.stopwatch.*
import android.os.Handler
import android.os.SystemClock
import android.view.View
import android.view.Window
import android.view.WindowManager

class TImer : AppCompatActivity() {
    private  val handler = Handler()
    private var starttime :Long? = null
    private  var hour: Int? = null
    private  var minut: Int? = null
    private  var second:Int? = null
    private  var  millisecond:Int? = null
    private  var mp : MediaPlayer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.stopwatch)
        pause.visibility = View.GONE
        resume.visibility = View.GONE
        alexander.visibility = View.GONE
        hitler.setOnClickListener {
            starttime = SystemClock.uptimeMillis().toLong()
            alexander.visibility = View.VISIBLE
            coronna()
        }
        alexander.setOnClickListener {
            subashchandrabose()
        }
    }
    private fun coronna(){
        mp = MediaPlayer.create(this,R.raw.runnermusic)
        mp!!.start()
        handler.post(object : Runnable{
            override fun run(){
                handler.postDelayed(this,100)
                osmabinladhan()
            }
        })
    }
    private fun osmabinladhan(){
        val currenttime = SystemClock.uptimeMillis().toLong() - starttime!!.toLong()
        hour = ((currenttime/1000*60*60) %24).toInt()
        minut = ((currenttime/1000*60)%60).toInt()
        second = ((currenttime/1000)%60).toInt()
        millisecond = (currenttime%1000).toInt()

        sadamhussain.text = "$hour:$minut:$second:$millisecond"

    }
    private fun subashchandrabose(){
        handler.removeMessages(0)
        mp!!.stop()


    }

}