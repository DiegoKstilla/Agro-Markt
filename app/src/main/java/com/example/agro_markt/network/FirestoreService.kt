package com.example.agro_markt.network

import com.example.agro_markt.model.Products
import com.google.firebase.firestore.FirebaseFirestore

const val PRODUCTS_COLLECTION_NAME = "products"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()

    fun getProducts(callback: Callback<List<Products>>){
        firebaseFirestore.collection(PRODUCTS_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Products::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}