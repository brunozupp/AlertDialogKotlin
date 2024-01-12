package com.novelitech.alertdialogkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.novelitech.alertdialogkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnExampleOne.setOnClickListener {

            val addContactDialog = AlertDialog.Builder(this)
                .setTitle("Add contact")
                .setMessage("Do you want to add Mr. Poop to your contacts list?")
                .setIcon(R.drawable.ic_add_contact_foreground)
                .setPositiveButton("Yes") { _, _ ->
                    Toast.makeText(this, "You added Mr. Poop to your contact list", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No") { _, _ ->
                    Toast.makeText(this, "You didn't add Mr. Poop to your contact list", Toast.LENGTH_SHORT).show()
                }
                .create()

            addContactDialog.show()

        }

        binding.btnExampleTwo.setOnClickListener {

            val options = arrayOf("First Item", "Second Item", "Three Item")

            val singleChoiceDialog = AlertDialog.Builder(this)
                .setTitle("Choose one of these options")
                .setSingleChoiceItems(options, 0) { _, i ->
                    Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("Accept") { _, _ ->
                    Toast.makeText(this, "You accepted the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Decline") { _, _ ->
                    Toast.makeText(this, "You didn't accept the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
                }
                .create()

            singleChoiceDialog.show()
        }

        binding.btnExampleThree.setOnClickListener {

            val options = arrayOf("First Item", "Second Item", "Three Item", "Fourth Item")

            val multiChoiceDialog = AlertDialog.Builder(this)
                .setTitle("Choose one of these options")
                .setMultiChoiceItems(options, booleanArrayOf(true,false,true,false)) { dialogInterface, i, isChecked ->

                    if(isChecked) {
                        Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
                    }
                }
                .setPositiveButton("Accept") { _, _ ->
                    Toast.makeText(this, "You accepted the MultiChoiceDialog", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Decline") { _, _ ->
                    Toast.makeText(this, "You didn't accept the MultiChoiceDialog", Toast.LENGTH_SHORT).show()
                }
                .create()

            multiChoiceDialog.show()
        }
    }
}