package com.app.showme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.showme.Api.APICall
import com.app.showme.Api.ResponseData
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userList.layoutManager = LinearLayoutManager(this)
        userList.setHasFixedSize(true)

        getUserData()
    }

    private fun getUserData() {
        val data = APICall.create().getAllUser();
        data.enqueue(object : Callback<ResponseData> {
            override fun onResponse(
                call: Call<ResponseData>?, responseData: Response<ResponseData>?
            ) {
                userList.adapter = UserAdapter(responseData?.body()?.data!!, this@MainActivity)
                (userList.adapter as UserAdapter).notifyDataSetChanged()
            }

            override fun onFailure(call: Call<ResponseData>?, t: Throwable?) {
                t!!.printStackTrace()
            }
        })
    }
}
