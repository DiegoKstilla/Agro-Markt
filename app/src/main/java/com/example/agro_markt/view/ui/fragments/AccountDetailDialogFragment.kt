package com.example.agro_markt.view.ui.fragments

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.agro_markt.R
import com.example.agro_markt.data.DBHelper
import com.example.agro_markt.data.Tables
import com.example.agro_markt.databinding.FragmentAccountDetailDialogBinding



class AccountDetailDialogFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentAccountDetailDialogBinding? = null
    private val binding get() = _binding!!

    lateinit var informacionDBHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        informacionDBHelper = DBHelper(activity)


    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {

        _binding = FragmentAccountDetailDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btSaveChanges.setOnClickListener{

            if (binding.etNameAdmin.text.isNotBlank() &&
                binding.etAddressAdmin.text.isNotBlank() &&
                binding.etPhoneAdmin.text.isNotBlank() &&
                binding.etEmailAdmin.text.isNotBlank() &&
                binding.etSocialReason.text.isNotBlank() &&
                binding.etCity.text.isNotBlank() &&
                binding.etStoreDescription.text.isNotBlank()) {

                informacionDBHelper.edit(1,
                    binding.etNameAdmin.text.toString(),
                    binding.etAddressAdmin.text.toString(),
                    binding.etPhoneAdmin.text.toString(),
                    binding.etEmailAdmin.text.toString(),
                    binding.etSocialReason.text.toString(),
                    binding.etCity.text.toString(),
                    binding.etStoreDescription.text.toString())

                Toast.makeText(activity, "Se guardaron los datos", Toast.LENGTH_LONG).show()

                binding.etNameAdmin.text.clear()
                binding.etAddressAdmin.text.clear()
                binding.etPhoneAdmin.text.clear()
                binding.etEmailAdmin.text.clear()
                binding.etSocialReason.text.clear()
                binding.etCity.text.clear()
                binding.etStoreDescription.text.clear()
            }

            val db:SQLiteDatabase = informacionDBHelper.readableDatabase
            val cursor = db.rawQuery("SELECT * FROM " + Tables.information.TABLE_NAME, null)
            if (cursor == null) {
                Toast.makeText(activity, "Base de datos vacia", Toast.LENGTH_LONG).show()
            }
            if (cursor.moveToFirst()) {
                do {
                    binding.etNameAdmin.setText(cursor.getString(1).toString())
                    binding.etAddressAdmin.setText(cursor.getString(2).toString())
                    binding.etPhoneAdmin.setText(cursor.getString(3).toString())
                    binding.etEmailAdmin.setText(cursor.getString(4).toString())
                    binding.etSocialReason.setText(cursor.getString(5).toString())
                    binding.etCity.setText(cursor.getString(6).toString())
                    binding.etStoreDescription.setText(cursor.getString(7).toString())
                } while (cursor.moveToNext())
            } else{
                Toast.makeText(activity, "Error al guardar los datos", Toast.LENGTH_LONG).show()
            }
        }
        val db : SQLiteDatabase = informacionDBHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM " + Tables.information.TABLE_NAME, null)
        if (cursor.moveToFirst()) {
            do {
                binding.etNameAdmin.setText(cursor.getString(1).toString())
                binding.etAddressAdmin.setText(cursor.getString(2).toString())
                binding.etPhoneAdmin.setText(cursor.getString(3).toString())
                binding.etEmailAdmin.setText(cursor.getString(4).toString())
                binding.etSocialReason.setText(cursor.getString(5).toString())
                binding.etCity.setText(cursor.getString(6).toString())
                binding.etStoreDescription.setText(cursor.getString(7).toString())
            } while (cursor.moveToNext())
        }
    }

}