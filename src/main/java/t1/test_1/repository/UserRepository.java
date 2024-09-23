package t1.test_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import t1.test_1.entity.User;

import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {


}



