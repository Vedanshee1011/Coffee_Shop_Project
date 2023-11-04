package com.example.coffee_shop_project


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    private var name: String? = null
    private var pasword: String? = null
    private var drink: String? = null
    private val builder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val aza: Intent = intent
        if (aza.hasExtra("name") && aza.hasExtra("pasword")) {
            name = aza.getStringExtra("name")
            pasword = aza.getStringExtra("pasword")
            val textViewgreaatings: TextView = findViewById(R.id.textViewGreetings)
            textViewgreaatings.text = "Hello $name what whould you like"
        }
    }

    fun onClickMakeOrder(view: View) {
        builder.setLength(0)
        val checkboxlemon: CheckBox = findViewById(R.id.checkboxLemon)
        val checkboxsugar: CheckBox = findViewById(R.id.checkboxSugar)
        val checkboxmilk: CheckBox = findViewById(R.id.checkboxMilk)

        if (checkboxlemon.isChecked) {
            builder.append(getString(R.string.lemon)).append(" ")
        }
        if (checkboxsugar.isChecked) {
            builder.append(getString(R.string.sugar)).append(" ")
        }
        if (checkboxmilk.isChecked) {
            builder.append(getString(R.string.milk)).append(" ")
        }

        var optionalsofdrink = ""
        val spinnerOfDrink_tea: Spinner = findViewById(R.id.spinnerOfDrinkTea)
        val spinnerOfDrink_cofee: Spinner = findViewById(R.id.spinnerOfDrinkCoffee)

        optionalsofdrink = if (drink == getString(R.string.tea)) {
            spinnerOfDrink_tea.selectedItem.toString()
        } else {
            spinnerOfDrink_cofee.selectedItem.toString()
        }

        val oredr = "Name $name\n Pasword $pasword\n Drink $drink Type of Drink $optionalsofdrink"

        val additions = if (builder.isNotEmpty()) {
            "Additions of drink ${builder.toString()}"
        } else {
            " "
        }

        val totalOrder = "$oredr  $additions"
        val intent = Intent(this, BillActivity::class.java)
        intent.putExtra("info", totalOrder)
        startActivity(intent)
    }

    fun onClickChangeDrink(view: View) {
        val radiobuton: RadioButton = view as RadioButton
        val id: Int = radiobuton.id
        val TextviewWhatAddtoTea: TextView = findViewById(R.id.TextviewWhatAddToTea)

        if (id == R.id.radioButtonTea) {
            drink = getString(R.string.tea)
            val spinnerOfDrink_tea: Spinner = findViewById(R.id.spinnerOfDrinkTea)
            val spinnerOfDrink_cofee: Spinner = findViewById(R.id.spinnerOfDrinkCoffee)
            val checkboxlemon: CheckBox = findViewById(R.id.checkboxLemon)

            spinnerOfDrink_tea.visibility = View.VISIBLE
            spinnerOfDrink_cofee.visibility = View.GONE
            checkboxlemon.visibility = View.VISIBLE
        } else if (id == R.id.radioButtonCoffee) {
            drink = getString(R.string.coffee)
            val spinnerOfDrink_tea: Spinner = findViewById(R.id.spinnerOfDrinkTea)
            val spinnerOfDrink_cofee: Spinner = findViewById(R.id.spinnerOfDrinkCoffee)

            spinnerOfDrink_cofee.visibility = View.VISIBLE
            spinnerOfDrink_tea.visibility = View.INVISIBLE
        }

        TextviewWhatAddtoTea.text = "What Add to your $drink"
    }
}