package com.example.jzpictureselectorsample

import android.app.Activity
import android.content.Intent
import android.util.Log
import com.example.jzpictureselector.PictureSelector
import com.orange.jzchi.jzframework.JzFragement
import kotlinx.android.synthetic.main.activity_main.view.*

class frag:JzFragement(R.layout.activity_main){
    override fun viewInit() {
        rootview.button.setOnClickListener {
            PictureSelector.getPicture(this)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==PictureSelector.requestCode && resultCode == Activity.RESULT_OK){
            val data=PictureSelector.getResult(data!!)
            Log.e("dataimage","${data}")
        }
    }
}