package com.tjeit.a20191221_03_librarypractice

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        callBtn.setOnClickListener {

//            전화 권한 요청 (3) => 획득 완료 되면 (1) => 인텐트를 이용해서 전화걸기 (2)

            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
//                    권한 획득 성공 상태

                    val uri = Uri.parse("tel:01051123237") // Uri자동완성시 android.net 제공 활용
                    val intent = Intent(Intent.ACTION_CALL, uri)
                    startActivity(intent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "전화 권한을 허용해야 걸 수 있습니다.", Toast.LENGTH_SHORT).show()
                }

            }


            TedPermission.with(mContext)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("권한 설정이 필요합니다.")
                .setPermissions(Manifest.permission.CALL_PHONE)  // Ctrl + Alt + o => 쓸데없이 임포트된 클래스 제거 단축키
                .check()



        }
    }

    override fun setValues() {

        Glide.with(mContext).load("http://post-phinf.pstatic.net/MjAxODA3MTlfMTIg/MDAxNTMxOTg5ODE5OTAw.edb-H-Rmhr2dFvKAqKA11flZ2k45cRi4Q4IaHirlMF4g.It6ziXN3vtf0R7B2p9DdwOy1hovG7aynuCPwAysStMcg.JPEG/jy180719b2.jpg?type=w1200").into(profileImg)

    }

}
