package com.example.agro_markt.data

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.fragment.app.FragmentActivity

class DBHelper(context: FragmentActivity?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "info"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE " + Tables.information.TABLE_NAME + " (" +
            Tables.information._id + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            Tables.information._nombre + " TEXT NOT NULL, " +
            Tables.information._direccion + " TEXT NOT NULL, " +
            Tables.information._telefono + " TEXT NOT NULL, " +
            Tables.information._correo + " TEXT NOT NULL, " +
            Tables.information._razonsocial + " TEXT NOT NULL, " +
            Tables.information._ciudad + " TEXT NOT NULL, " +
            Tables.information._descripcion + " TEXT NOT NULL) ")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val orderErase = "DROP TABLE IF EXIST " + Tables.information.TABLE_NAME
        db!!.execSQL(orderErase)
        onCreate(db)
    }

    fun insert(name:String, address: String, phone: String, email: String, socialReason: String, city: String, description: String) {
        val data = ContentValues()
        data.put(Tables.information._nombre, name)
        data.put(Tables.information._direccion, address)
        data.put(Tables.information._telefono, phone)
        data.put(Tables.information._correo, email)
        data.put(Tables.information._razonsocial, socialReason)
        data.put(Tables.information._ciudad, city)
        data.put(Tables.information._descripcion, description)
        val db = this.writableDatabase

        db.insert(Tables.information.TABLE_NAME, null, data)
        db.close()
    }

    fun edit(id: Int,name: String, address: String, phone: String, email: String, socialReason: String, city: String, description: String) {
        val num = 1
        val args = arrayOf(num.toString())

        val data = ContentValues()
        data.put(Tables.information._nombre, name)
        data.put(Tables.information._direccion, address)
        data.put(Tables.information._telefono, phone)
        data.put(Tables.information._correo, email)
        data.put(Tables.information._razonsocial, socialReason)
        data.put(Tables.information._ciudad, city)
        data.put(Tables.information._descripcion, description)
        val db = this.writableDatabase

        db.update(Tables.information.TABLE_NAME, data, " _id = ?", args)
        db.close()
    }

}
