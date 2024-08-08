package t1.test_1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t1.test_1.entity.Product;
import t1.test_1.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository repository;


    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    public List<Product> getProducts(){

        return repository.findAll();
    }

    public Product getProductById(int id){

        return repository.findById(id).orElse(null);
    }



    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product Removed !! " +id;
    }

    public Product put(Product product){

        Product existingProduct = repository.findById(product.getPID()).orElse(null);
        existingProduct.setP_name(product.getP_name());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }



}
