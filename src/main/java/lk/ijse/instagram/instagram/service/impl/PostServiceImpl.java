package lk.ijse.instagram.instagram.service.impl;


import lk.ijse.instagram.instagram.entity.Post;
import lk.ijse.instagram.instagram.repository.PostRepository;
import lk.ijse.instagram.instagram.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;


    @Override
    public List<Post> getAllPost() {

        return null;
    }

    @Override
    public Post addPost(Post post) {

        return postRepository.save(post);
    }
}
