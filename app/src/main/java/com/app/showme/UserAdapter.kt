package com.app.showme

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_item.view.*
import java.util.*

class UserAdapter(private val userList: List<UserModel>, private val context: Context) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.firstName.text = user.first_name.toUpperCase(Locale.getDefault());
        holder.lastName.text = user.last_name
        holder.email.text = user.email
        Picasso.get().load(user.avatar).into(holder.profile)

        holder.userView.setOnClickListener {
            val intent = Intent(context, Profile::class.java)
            intent.putExtra(context.getString(R.string.USER_INFO), user)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var firstName = itemView.name!!
        var lastName = itemView.role!!
        var email = itemView.position!!
        var profile = itemView.profile_image!!
        var userView = itemView.userView!!
    }
}