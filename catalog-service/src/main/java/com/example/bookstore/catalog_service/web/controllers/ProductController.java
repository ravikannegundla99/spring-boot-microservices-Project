package com.example.bookstore.catalog_service.web.controllers;


import com.example.bookstore.catalog_service.domain.PagedResult;
import com.example.bookstore.catalog_service.domain.Product;
import com.example.bookstore.catalog_service.domain.ProductNotFoundException;
import com.example.bookstore.catalog_service.domain.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/products")
class ProductController {

private final ProductService productService;

ProductController(ProductService productService){
    this.productService=productService;
}

@GetMapping
PagedResult<Product> getProducts(@RequestParam(name="page" ,defaultValue = "1") int PageNo){
    return productService.getProducts(PageNo);

}

    @GetMapping("/{code}")
    ResponseEntity<Product> getProductByCode(@PathVariable String code) {
//        log.info("Fetching product for code: {}", code);
        return productService
                .getProductByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.forCode(code));
    }



}
