package pl.nullpointerexception.mapping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexception.mapping.controller.dto.PostDto;
import pl.nullpointerexception.mapping.controller.dto.PostReadDto;
import pl.nullpointerexception.mapping.controller.dto.PostTitleDto;
import pl.nullpointerexception.mapping.model.Post;
import pl.nullpointerexception.mapping.service.PostService;

import javax.validation.Valid;
import java.util.List;

import static pl.nullpointerexception.mapping.controller.mapper.PostDtoMapper.mapPostToPostTitleDto;
import static pl.nullpointerexception.mapping.controller.mapper.PostMapper.mapToPost;
import static pl.nullpointerexception.mapping.controller.mapper.PostReadDtoMapper.mapPostToPostReadDtoList;

@RestController
public class PostController {

    private static final Long EMPTY_ID = null;
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<PostReadDto> getPosts() {
        return mapPostToPostReadDtoList(postService.getPosts());
    }

    @GetMapping("/posts/title")
    public List<PostTitleDto> getPostsTitles() {
        return mapPostToPostTitleDto(postService.getPosts());
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody @Valid PostDto postDto) {
        return postService.addPost(mapToPost(EMPTY_ID, postDto));
    }

    @PutMapping("/posts/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody @Valid PostDto postDto) {
        postService.updatePost(mapToPost(id, postDto));
    }
}
