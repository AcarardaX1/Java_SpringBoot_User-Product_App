package t1.test_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t1.test_1.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    User user(User existingUser);
}



