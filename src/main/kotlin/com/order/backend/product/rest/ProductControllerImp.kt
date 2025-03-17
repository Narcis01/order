package com.order.backend.product.rest

import com.order.backend.product.ProductResource
import com.order.backend.product.service.ProductService
import com.order.backend.product.service.ProductServiceImp
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/products")
class ProductControllerImp(
    val productService: ProductService
): ProductController {

    @PostMapping("/product")
    override fun create(@RequestBody productResource: ProductResource): ProductResource {
        return productService.create(productResource.toWrapper()).toResource()
    }

    @DeleteMapping("/product/{id}")
    override fun delete(@PathVariable id: Long) {
        productService.delete(id)
    }

    @GetMapping("/product/{id}")
    override fun getProduct(@PathVariable id: Long): ProductResource {
        return productService.getProduct(id).toResource()
    }

    @GetMapping
    override fun getProduct(): List<ProductResource> {
        return productService.getProducts().map { it.toResource() }
    }
}