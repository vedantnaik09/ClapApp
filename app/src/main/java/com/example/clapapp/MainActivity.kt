package com.example.clapapp

import android.content.Context
import android.media.AudioManager
import android.media.AudioManager.FLAG_SHOW_UI
import android.media.AudioManager.STREAM_NOTIFICATION
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore.Audio.Media
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var  mediaplayer: MediaPlayer? = null
    private lateinit var seekBar: SeekBar
    private lateinit var runnable: Runnable
    private lateinit var handler: Handler
//    private lateinit var  am: AudioManager
//      private lateinit var audio: AudioManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekBar=findViewById(R.id.sbClapping)
        handler=Handler(Looper.getMainLooper())

        val play=findViewById<FloatingActionButton>(R.id.fabPlay)

        play.setOnClickListener(){
            if(mediaplayer == null){
                mediaplayer= MediaPlayer.create(this,R.raw.applauding)
                initializeSeekBar()
            }
            mediaplayer?.start()
        }
        val pause=findViewById<FloatingActionButton>(R.id.fabPause)
        pause.setOnClickListener(){

            mediaplayer?.pause()
        }

        val stop=findViewById<FloatingActionButton>(R.id.fabStop)
        stop.setOnClickListener(){
            mediaplayer?.stop()
            mediaplayer?.reset()
            mediaplayer?.release()
            mediaplayer=null
            handler.removeCallbacks(runnable)
            seekBar.progress=0
        }

//        am = this.getSystemService(Context.AUDIO_SERVICE) as AudioManager
//        audio = this.getSystemService(Context.AUDIO_SERVICE) as AudioManager;
//-----------------------------------------------------------------------------------------------------------------------
//        val button=findViewById<Button>(R.id.btnClap)
//
//
//        mediaplayer.setVolume(1f,1f)
//        button.setOnClickListener(){
////            am.setStreamVolume(AudioManager.STREAM_MUSIC,am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), FLAG_SHOW_UI)
//            mediaplayer.start()
//       }
    }
    private fun initializeSeekBar(){

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) mediaplayer?.seekTo(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        val tvPlayed=findViewById<TextView>(R.id.tvPlayed)
        val tvDue=findViewById<TextView>(R.id.tvDue)
        seekBar.max=mediaplayer!!.duration
        runnable=Runnable{

            seekBar.progress= mediaplayer!!.currentPosition
            val playedTime=mediaplayer!!.currentPosition/1000
            tvPlayed.text="$playedTime sec"
            val duration=mediaplayer!!.duration/1000
            val dueTime=duration-playedTime
            tvDue.text="$dueTime sec"
            handler.postDelayed(runnable,1000)
        }

        handler.postDelayed(runnable,1000)
    }
}