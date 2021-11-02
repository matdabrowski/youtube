package pl.nullpointerexception.mapping.service;

import org.springframework.stereotype.Service;
import pl.nullpointerexception.mapping.model.Post;
import pl.nullpointerexception.mapping.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() {
        return postRepository.findAllPostsWithComments();
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public void updatePost(Post post) {
        postRepository.save(post);
    }
}
