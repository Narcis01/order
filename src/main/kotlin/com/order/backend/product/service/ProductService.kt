package com.order.backend.product.service

import com.order.backend.product.ProductResource
import com.order.backend.product.ProductWrapper

interface ProductService {

    fun create(productResource: ProductWrapper): ProductWrapper

    fun delete(id: Long)

    fun getProduct(id: Long): ProductWrapper

    fun getProducts(): List<ProductWrapper>
}