package t1.test_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t1.test_1.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}



