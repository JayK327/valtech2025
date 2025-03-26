package com.valtech.practiseSpringEcom.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.valtech.practiseSpringEcom.models.Product;
import com.valtech.practiseSpringEcom.repos.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public Product getProductById(int id) {
		return productRepo.findById(id).orElse(new Product());
	}

//	public Product addProduct(Product product, MultipartFile image) throws IOException {
//		product.setImageData(image.getBytes());
//		product.setImageName(image.getOriginalFilename());
//		product.setImageType(image.getContentType());
//		return productRepo.save(product);
//	}

}
