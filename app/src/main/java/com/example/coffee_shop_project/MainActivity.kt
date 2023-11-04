package com.example.coffee_shop_project


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private var edittextname:EditText? = null
    private var edittextpasword:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edittextname=findViewById(R.id.Edittextname)
        edittextpasword=findViewById(R.id.editTextPassword)
    }

    fun onCklickCreateOrder(view: android.view.View) {
        val name:String?=edittextname?.text?.toString()?:"User"
        val pasword:String?=edittextpasword?.text?.toString()?:"Pasword"
        var aza:Intent=Intent(this,OrderActivity::class.java)
        aza.putExtra("name",name)
        aza.putExtra("pasword",pasword)
        startActivity(aza)
    }
}