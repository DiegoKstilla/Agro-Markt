//package com.example.agro_markt.viewmodel
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.example.agro_markt.model.Products
//import com.example.agro_markt.network.Callback
//import com.example.agro_markt.network.FirestoreService
//import java.lang.Exception
//
//class OrderViewModel: ViewModel() {
//    val firestoreService = FirestoreService()
//    val listProducts: MutableLiveData<List<Products>> = MutableLiveData()
//    var isLoading = MutableLiveData<Boolean>()
//
//    fun refresh() {
//        getProductsFromFirebase()
//    }
//
//    fun getProductsFromFirebase(){
//        firestoreService.getProducts(object : Callback<List<Products>>) {
//            override fun onSuccess(result: List<Products>?) {
//                listProducts.postValue(result)
//                processFinished()
//            }
//            override fun onFailet(exception: Exception){
//                processFinished()
//            }
//        }
//    }
//
//    fun processFinished() {
//        isLoading.value = true
//    }
//
//}