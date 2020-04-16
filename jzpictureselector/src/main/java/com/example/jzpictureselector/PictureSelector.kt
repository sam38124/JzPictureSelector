package com.example.jzpictureselector

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment
import com.orange.jzchi.jzframework.JzActivity
import com.orange.jzchi.jzframework.callback.permission_C
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.internal.entity.CaptureStrategy

object PictureSelector{
    var requestCode=99
    fun getPicture(con:Fragment){
        JzActivity.getControlInstance().permissionRequest(arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA), object :
            permission_C {
            var resize=0
            override fun requestFalse(a: String) {
                JzActivity.getControlInstance().toast("此操作必須取相簿權限")
            }

            override fun requestSuccess(a: String) {
                resize+=1
                Matisse.from(con)
                    .choose(MimeType.ofImage())//图片类型
                    .countable(false)//true:选中后显示数字;false:选中后显示对号
                    .maxSelectable(1)
                    .showSingleMediaType(true)
                    .capture(true)//选择照片时，是否显示拍照
                    .imageEngine(Util_Glide_Egine())
                    .captureStrategy(
                        CaptureStrategy(
                            true,
                            "PhotoPicker"
                        )
                    )//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                    .forResult(requestCode)//
            }
        }, 10)
    }
    fun getPicture(con:Activity){
        JzActivity.getControlInstance().permissionRequest(arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA), object :
            permission_C {
            var resize=0
            override fun requestFalse(a: String) {
                JzActivity.getControlInstance().toast("此操作必須取相簿權限")
            }

            override fun requestSuccess(a: String) {
                resize+=1
                Matisse.from(con)
                    .choose(MimeType.ofImage())//图片类型
                    .countable(false)//true:选中后显示数字;false:选中后显示对号
                    .maxSelectable(1)
                    .showSingleMediaType(true)
                    .capture(true)//选择照片时，是否显示拍照
                    .imageEngine(Util_Glide_Egine())
                    .captureStrategy(
                        CaptureStrategy(
                            true,
                            "PhotoPicker"
                        )
                    )//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                    .forResult(requestCode)//
            }
        }, 10)

    }
    fun getResult(data: Intent):List<Uri>{
        val result = Matisse.obtainResult(data)
        return result
    }
}