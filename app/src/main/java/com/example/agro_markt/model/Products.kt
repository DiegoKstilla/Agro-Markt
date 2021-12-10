package com.example.agro_markt.model

import java.io.Serializable

abstract class Products: Serializable {
    lateinit var prod_name: String
    lateinit var price: String
    lateinit var description: String
    lateinit var city: String
}