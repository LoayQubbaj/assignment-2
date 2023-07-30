package com.example.restaurant_menu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val orderButton = findViewById<Button>(R.id.orderButton)
        orderButton.setOnClickListener {
            showOrderDialog()
        }

        val aboutButton = findViewById<Button>(R.id.aboutButton)
        aboutButton.setOnClickListener {
            showToast("Restaurant Menu App")
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_order -> {
                showOrderDialog()
                true
            }
            R.id.menu_about -> {
                showToast("Restaurant Menu App")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showOrderDialog() {
        val orderDialog = OrderDialogFragment()
        orderDialog.show(supportFragmentManager, "OrderDialog")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}
