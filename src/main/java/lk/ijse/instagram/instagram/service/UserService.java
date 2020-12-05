package lk.ijse.instagram.instagram.service;

import lk.ijse.instagram.instagram.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    User addUser(User user);

    User findUser(int id);
}
