package lk.ijse.instagram.instagram.dto.authorization;


import lk.ijse.instagram.instagram.entity.UserSession;
import lk.ijse.instagram.instagram.repository.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    @Autowired
    private UserSessionRepository userSessionRepository;

    public UserSession validate(String accessToken){
        return userSessionRepository.findByAccessToken(accessToken).get();
    }
}
