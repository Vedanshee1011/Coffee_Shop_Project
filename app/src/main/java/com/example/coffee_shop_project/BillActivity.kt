package com.example.coffee_shop_project


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class BillActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill)

        val alpha: Intent = intent
        val info: String? = alpha.getStringExtra("info")

        val listViewInfoAboutOrder: ListView = findViewById(R.id.listViewInfoAboutOrder1)

        val orderDetails = info?.split("\n") ?: emptyList()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, orderDetails)

        listViewInfoAboutOrder.adapter = adapter
    }
}
