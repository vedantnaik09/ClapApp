package com.example.clapapp

import android.content.Context
import android.media.AudioManager
import android.media.AudioManager.FLAG_SHOW_UI
import android.media.AudioManager.STREAM_NOTIFICATION
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var  mediaplayer: MediaPlayer?=null
//    private lateinit var  am: AudioManager
//      private lateinit var audio: AudioManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pause=findViewById<Button>(R.id.fabPause)
        pause.setOnClickListener(){
            if(mediaplayer==null){
            mediaplayer= MediaPlayer.create(this,R.raw.applauding)
            }
            mediaplayer?.start()
        }
        val play=findViewById<Button>(R.id.fabPlay)
        play.setOnClickListener(){

        }
        val stop=findViewById<Button>(R.id.fabStop)
        stop.setOnClickListener(){

        }
        mediaplayer= MediaPlayer.create(this,R.raw.applauding)
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
}