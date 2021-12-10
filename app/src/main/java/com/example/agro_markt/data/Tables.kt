package com.example.agro_markt.data

import android.app.Person

class Tables {

    abstract class information {
        companion object {
            val _id = "_id"
            val TABLE_NAME = "Info"
            val _nombre = "Name"
            val _direccion = "Address"
            val _telefono = "Phone"
            val _correo = "Email"
            val _razonsocial = "SocialReason"
            val _ciudad = "City"
            val _descripcion = "StoreDescription"
            var persons: MutableList<Person> = ArrayList()

        }
    }
}