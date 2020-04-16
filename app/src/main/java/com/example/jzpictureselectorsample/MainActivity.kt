package com.example.jzpictureselectorsample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.jzpictureselector.PictureSelector
import com.orange.jzchi.jzframework.JzActivity

class MainActivity : JzActivity() {

    override fun savedInstanceAble(): Boolean {
      return false
    }

    override fun viewInit(rootview: View) {
getControlInstance().setHome(frag(),"frag")
    }

    override fun changePageListener(tag: String, frag: Fragment) {

    }

    override fun keyEventListener(event: KeyEvent): Boolean {
      return true
       }


}
