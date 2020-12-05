package lk.ijse.instagram.instagram.controller;


import lk.ijse.instagram.instagram.dto.authorization.AuthorizationInfo;
import lk.ijse.instagram.instagram.entity.Adminuser;
import lk.ijse.instagram.instagram.entity.UserSession;
import lk.ijse.instagram.instagram.repository.UserRepository;
import lk.ijse.instagram.instagram.repository.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthorizationRest {

    @Autowired
    private UserSessionRepository userSessionRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public AuthorizationInfo auth(@RequestParam String username , @RequestParam String password){
        Optional<Adminuser> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()){
            Adminuser adminuser = userOptional.get();

            if (!adminuser.getPassword().equals(password)){
                throw new RuntimeException("Password does not match");
            }

            UserSession userSession = new UserSession();
            userSession.setAccessToken(new Date().getTime() + "");
//            userSession.setExpireTime();
            userSession.setId(adminuser.getId());


            userSessionRepository.save(userSession);

            AuthorizationInfo authorizationInfo = new AuthorizationInfo();
            authorizationInfo.setAccessToken(userSession.getAccessToken());
            authorizationInfo.setPermissions(adminuser.getPermissions());


            return authorizationInfo;
        } else throw new RuntimeException("User not found");
    }
}
