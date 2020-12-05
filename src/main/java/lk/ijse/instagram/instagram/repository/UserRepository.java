package lk.ijse.instagram.instagram.repository;

import lk.ijse.instagram.instagram.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String Email);
}
