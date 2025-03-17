package com.order.backend.product.rest

import com.order.backend.product.ProductResource
import org.springframework.web.bind.annotation.RestController


interface ProductController {

    fun create(productResource: ProductResource): ProductResource

    fun delete(id: Long)

    fun getProduct(id: Long): ProductResource

    fun getProduct(): List<ProductResource>
}