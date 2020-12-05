package lk.ijse.instagram.instagram.repository;


import lk.ijse.instagram.instagram.entity.UserSession;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.Optional;

public interface UserSessionRepository extends PagingAndSortingRepository<UserSession,Long> {

    Optional<UserSession> findByAccessToken(String accessToken);

    void deleteByExpireTimeLessThan(Date date);

}
