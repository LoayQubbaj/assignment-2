package com.example.restaurant_menu

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class OrderDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val items = arrayOf("Pizza", "Salad", "Burger", "Drink")

        return AlertDialog.Builder(requireContext())
            .setTitle("Place an Order")
            .setItems(items) { _, which ->
                val selectedItem = items[which]
                showOrderConfirmation(selectedItem)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
    }

    private fun showOrderConfirmation(selectedItem: String) {
        val message = "You ordered $selectedItem"
        showToast(message)
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
