package com.example.agro_markt.view.adapter

import com.example.agro_markt.model.Products
import java.text.FieldPosition

interface ProductsListener {
    fun OnProductsClick(product: Products, position: Int)
}