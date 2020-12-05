package lk.ijse.instagram.instagram.repository;


import lk.ijse.instagram.instagram.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
