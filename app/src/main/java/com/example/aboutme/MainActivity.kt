package com.example.aboutme

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Uzair Jamal")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName

//        findViewById<Button>(R.id.button).setOnClickListener {
//            addNickName(it)
//        }
            binding.button.setOnClickListener {
                addNickName(it)
            }

    }

    private fun addNickName(view: View){

//        nickNameTextView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
        binding.apply {
//            nicknameText.text = editText.text
            myName?.nickName = nicknameText.text.toString()
            invalidateAll()
            editText.visibility = View.GONE
            button.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        //Hide Keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)

    }
}