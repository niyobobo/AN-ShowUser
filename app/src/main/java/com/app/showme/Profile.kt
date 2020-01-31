package com.app.showme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val user = intent.getSerializableExtra(this.getString(R.string.USER_INFO)) as? UserModel

        Picasso.get().load(user?.avatar).into(circleImageView)
        full_name.text = this.getString(R.string.full_name, user?.first_name , user?.last_name)
        email.text = user?.email
    }
}
