package com.order.backend.product.service

import com.order.backend.product.ProductRepository
import com.order.backend.product.ProductResource
import com.order.backend.product.ProductWrapper
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class ProductServiceImp(
    val productRepository: ProductRepository
): ProductService {
    override fun create(productResource: ProductWrapper): ProductWrapper {
        return productRepository.save(productResource.toEntity()).toWrapper()
    }

    override fun delete(id: Long) {
        productRepository.deleteById(id)
    }

    override fun getProduct(id: Long): ProductWrapper {
        return productRepository.findById(id).get().toWrapper()
    }

    override fun getProducts(): List<ProductWrapper> {
        return productRepository.findAll().map { it.toWrapper() }
    }
}