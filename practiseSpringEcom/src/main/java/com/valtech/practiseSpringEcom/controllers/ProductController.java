package com.valtech.practiseSpringEcom.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.valtech.practiseSpringEcom.models.Product;
import com.valtech.practiseSpringEcom.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		//ResponseEntity is to change the status , By default is working therefore status is 200 OK.
		return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.ACCEPTED);
	}
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product product=productService.getProductById(id);
		if(product.getId()>0) {
			return new ResponseEntity<>(product,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	@PostMapping("/product")
//	public ResponseEntity<?> addProduct(@RequestPart Product product,@RequestPart MultipartFile imageFile){
//		Product savedProduct;
//		try {
//			savedProduct = productService.addProduct(product,imageFile);
//			return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
//
//		} catch (IOException e) {
//			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	

}
