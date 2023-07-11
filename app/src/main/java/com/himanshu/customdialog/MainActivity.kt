package com.himanshu.customdialog

import android.app.AlertDialog
import android.app.Dialog
import kotlin.random.Random
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.himanshu.customdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var outName : String ?= ""

    var outRollNo: Int?=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnUpdate.setOnClickListener {
            //Toast.makeText(this,"$random",Toast.LENGTH_SHORT).show()
            var dialog= Dialog(this)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.custom_dialog_layout)

           var etName=dialog.findViewById<EditText>(R.id.etName)
            var etRollNo=dialog.findViewById<EditText>(R.id.etRollNo)
            var btnSave=dialog.findViewById<Button>(R.id.btnSave)
            btnSave.setOnClickListener {
                if (etName.text.toString().isNullOrEmpty()) {
                    etName.error="Please Enter your name"
                } else if (etRollNo.text.toString().isNullOrEmpty()) {
                    etRollNo.error="Please Enter your Roll No"
                } else {
                    binding.tvName.text = etName.text.toString()
                    binding.tvRollNo.text = etRollNo.text.toString()

                    dialog.dismiss()

                }
            }
            dialog.show()
        }

        binding.btnDelete.setOnClickListener {
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Delete")
            alert.setMessage("Do you want to delete information?")
            alert.setCancelable(false)
            alert.setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "Deleted successfully", Toast.LENGTH_SHORT).show()
                binding.tvName.text = null
                binding.tvRollNo.text = null
            }
            alert.setNegativeButton("No"){ _, _ ->
                Toast.makeText(this,"Not Deleted",Toast.LENGTH_SHORT).show()
            }
            alert.show()
        }


        binding.btnRandomName.setOnClickListener {
            var alert = AlertDialog.Builder(this)
                alert.setTitle("Random String")
            alert.setMessage("Select number of characters")
            alert.setCancelable(false)
            alert.setPositiveButton("Add 3"){_, _->
                    Toast.makeText(this,"Added successfully",Toast.LENGTH_SHORT).show()
                    for(i in 0..2){
                       var random = ('A'..'Z').random()
                       outName+=random
                    }
                    binding.tvName.text=outName
                }

            alert.setNegativeButton("Add 4"){_,_->
                    Toast.makeText(this,"Added successfully",Toast.LENGTH_SHORT).show()
                    for(i in 0..3){
                        var random = ('A'..'Z').random()
                        outName+=random
                    }
                    binding.tvName.text=outName
                }
            alert.setNeutralButton("Clear"){_,_->
                    Toast.makeText(this,"Cleared successfully",Toast.LENGTH_SHORT).show()
                        outName=""
                    binding.tvName.text=outName
                }
            alert.show()
        }
        binding.btnRandomRollNo.setOnClickListener {
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Random Number")
            alert.setMessage("Select number of digits")
            alert.setCancelable(false)
            alert.setPositiveButton("3 digit"){_, _->
                Toast.makeText(this,"Added successfully",Toast.LENGTH_SHORT).show()
                    var random = (100..999).random()
                binding.tvRollNo.text=random.toString()
            }

            alert.setNegativeButton("4 digit"){_,_->
                Toast.makeText(this,"Added successfully",Toast.LENGTH_SHORT).show()
                var random = (1000..9999).random()
                binding.tvRollNo.text=random.toString()
            }
            alert.setNeutralButton("Clear"){_,_->
                Toast.makeText(this,"Cleared successfully",Toast.LENGTH_SHORT).show()
                binding.tvRollNo.text=null
            }
            alert.show()
        }

    }
}
