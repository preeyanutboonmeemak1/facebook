package com.preeyanut.facebook


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.facebook.login.LoginManager

/**
 * A simple [Fragment] subclass.
 */
class Profile : Fragment() {

    var PhotoURL : String = ""
    var Name : String = ""

    fun newInstance(url: String,name : String): Profile {

        val profile = Profile()
        val bundle = Bundle()
        bundle.putString("PhotoURL", url)
        bundle.putString("Name", name)
        profile.setArguments(bundle)

        return profile
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val ivProfilePicture = view.findViewById(R.id.iv_profile) as ImageView
        val tvName = view.findViewById(R.id.tv_name) as TextView
        val login_button2 = view.findViewById(R.id.login_button2) as Button

        Log.d("PhotoURL:",PhotoURL)

        Glide.with(activity!!.baseContext)
            .load(PhotoURL)
            .into(ivProfilePicture)

        tvName.setText(Name)

        login_button2.setOnClickListener{

            LoginManager.getInstance().logOut()
            activity!!.supportFragmentManager.popBackStack()
        }


        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            PhotoURL = bundle.getString("PhotoURL").toString()
            Name = bundle.getString("Name").toString()

        }

    }



}
