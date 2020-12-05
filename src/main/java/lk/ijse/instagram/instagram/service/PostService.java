package lk.ijse.instagram.instagram.service;


import lk.ijse.instagram.instagram.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPost();

    Post addPost(Post post);

}
