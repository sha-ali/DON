package com.example.dontimer

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_fullscreen.*
import kotlinx.android.synthetic.main.nelsonmandela.view.*
import java.util.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class FullscreenActivity : AppCompatActivity() {
    private val handler = Handler()
    private var yearof: Int? = null
    private var monthof: Int? = null
    private var dayof: Int? = null
    private var hourof: Int? = null
    private var minutsof: Int? = null
    private var ampmof: Int? = null
    private var eventname: String? = null
    lateinit var notificationManager : NotificationManager
    lateinit var notificationChannel : NotificationChannel
    lateinit var builder : Notification.Builder
    private  val channelId = "com.example.dontimer"
    private  val description = "end time"


    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_fullscreen)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        martinlutharking.visibility = View.GONE

        donaldtrump.setOnClickListener {
            //hilari()
            kattabomma.visibility = View.GONE
            rajaravivarmma.visibility = View.GONE

            marconni2.text = ""
            marconni.text = ""
            modi()
        }
        martinlutharking.setOnClickListener {
            val mp = MediaPlayer.create(this,R.raw.wickedmalelaugh1)
            mp.start()
            marconni.text = ""
            marconni2.text = "Welcome back"
            handler.removeMessages(0)
            donaldtrump.visibility = View.VISIBLE
            kattabomma.visibility = View.VISIBLE
            rajaravivarmma.visibility = View.VISIBLE

            martinlutharking.visibility = View.GONE

        }
        kattabomma.setOnClickListener {
            intent = Intent(this,TImer::class.java)
            startActivity(intent)
        }
        rajaravivarmma.setOnClickListener {
            intent = Intent(this, Counter::class.java)
            startActivity(intent)
        }

    }
    private  fun modi(){
        val yeardate = Calendar.getInstance()
        val datepicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
            view, year, month, dayOfMonth ->
            yearof = year
            monthof = month
            dayof = dayOfMonth
            manmohan()
        },yeardate[Calendar.YEAR],yeardate[Calendar.MONTH],yeardate[Calendar.DAY_OF_MONTH])
        datepicker.show()

    }
    private fun manmohan(){
        val yeardate = Calendar.getInstance()
        val dayss = TimePickerDialog.OnTimeSetListener { timepicker, hourOfDay, minute ->
            yeardate.set(Calendar.HOUR,hourOfDay)
            yeardate.set(Calendar.MINUTE,minute)
            hourof = hourOfDay
            minutsof = minute
            if (Calendar.AM == 0){
                ampmof = 0
                Log.i("amptag","--------------@##$ampmof")

            }else{
                ampmof = 1
            }
            obama()
            //hilari()
        }
        TimePickerDialog(this, dayss, yeardate.get(Calendar.HOUR), yeardate.get(Calendar.MINUTE),false).show()
    }
    private fun obama(){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.nelsonmandela, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("Content")
        val mAlertDialog = mBuilder.show()
        mDialogView.chegura.setOnClickListener {
            mAlertDialog.dismiss()
            eventname = mDialogView.victoriya.text.toString()
            hilari()

        }
    }
    private fun hilari(){
        martinlutharking.visibility = View.VISIBLE
        donaldtrump.visibility = View.GONE
        handler.post(object : Runnable{
            override fun run() {
                handler.postDelayed(this, 1000)
                updatetime()
            }
        })

    }
    private  fun updatetime(){
        val currentdate = Calendar.getInstance()

        var eventdate = Calendar.getInstance()
        eventdate[Calendar.YEAR]= yearof!!
        eventdate[Calendar.MONTH] = monthof!!
        eventdate[Calendar.DAY_OF_MONTH] = dayof!!
        eventdate[Calendar.HOUR] = hourof!!
        eventdate[Calendar.MINUTE] = minutsof!!
        eventdate[Calendar.AM_PM] = ampmof!!
        eventdate[Calendar.SECOND] = 0
        Log.i("tag","------------->$ampmof")
        //eventdate.timeZone = TimeZone.getTimeZone("GMT+0:15")
        val diff = eventdate.timeInMillis - currentdate.timeInMillis
        //Log.i("tag diff","$diff")
        if (diff<0){
            Toast.makeText(this, "use futer date", Toast.LENGTH_SHORT).show()
            endEvent(currentdate, eventdate) }

        val days = diff/(24*60*60*1000)
        val hours = diff/(1000*60*60)%24
        val minuts = diff/(1000*60)%60
        val seconds = (diff/1000)%60
        val milisecond:Long = (diff%100)
        if (days==0.toLong() && hours==0.toLong() && minuts==0.toLong() && seconds<=10) {
            val animationzoomout = AnimationUtils.loadAnimation(this, R.anim.zoominanim)
            marconni.startAnimation(animationzoomout)
            marconni.setTextColor(Color.RED)
            val mp = MediaPlayer.create(this,R.raw.tick)
            mp.start()
            marconni.text = "$seconds"

        }
        else{
            marconni.text = "${days}d ${hours}h ${minuts}m ${seconds}s"
            marconni.clearAnimation()
        }
        endEvent(currentdate, eventdate)
    }
    private fun endEvent(currentdate: Calendar, eventdate: Calendar) {
        if (currentdate.time >= eventdate.time) {
            Log.i("taagggg","function working")
            val mp = MediaPlayer.create(this,R.raw.wickedmalelaugh1)
            mp.start()
            marconni.setTextColor(Color.WHITE)
            marconni.text = ""
            marconni2.text = eventname
            shabeeb()
            //Stop Handler
            handler.removeMessages(0)
            donaldtrump.visibility = View.VISIBLE
            martinlutharking.visibility = View.GONE
            kattabomma.visibility = View.VISIBLE
        }
    }
    private fun shabeeb(){
        val intent = Intent(this, LauncherActivity::class.java)
        val pendingIntent= PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.BLUE
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this,channelId)
                .setContentTitle("DON TIME")
                .setContentText("timer end")
                .setSmallIcon(R.drawable.timer)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.timer))
                .setContentIntent(pendingIntent)
        }else{
            builder = Notification.Builder(this)
                .setContentTitle("Time end")
                .setContentText("timer end")
                .setSmallIcon(R.drawable.timer)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.timer))
                .setContentIntent(pendingIntent)
        }
        notificationManager.notify(1234,builder.build())

    }
}

