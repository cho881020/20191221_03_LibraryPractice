package com.tjeit.a20191221_03_librarypractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_large_profile_image.*

class LargeProfileImageActivity : BaseActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_large_profile_image)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        val imageURL = intent.getStringExtra("imgUrl")

        Glide.with(mContext).load(imageURL).into(largeImgView)

    }
}
