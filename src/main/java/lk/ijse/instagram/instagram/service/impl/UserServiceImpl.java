package lk.ijse.instagram.instagram.service.impl;

import lk.ijse.instagram.instagram.entity.User;
import lk.ijse.instagram.instagram.repository.UserRepository;
import lk.ijse.instagram.instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        User usr= userRepository.findUserByEmail(user.getEmail());

        if(usr==null){
            return userRepository.save(user);
        }

        return null;
    }

    @Override
    public User findUser(int id) {
        userRepository.findById(id);
        return null;
    }
}
