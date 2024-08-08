package t1.test_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import t1.test_1.entity.Product;
import t1.test_1.service.ProductService;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductService service;


    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {

        return service.saveProduct(product);

    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {

        return service.saveProducts(products);

    }
    @GetMapping("/products")
        public List<Product> findAllProducts(){
             return service.getProducts();
    }

    @GetMapping("/product/{id}")
        public Product findProductById(@PathVariable int id){
            return service.getProductById(id);
    }

    @PutMapping("/update")
        public Product updateProduct(@RequestBody Product product) {

        return service.put(product);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);

    }

}
