package pl.nullpointerexception.mapping.controller.mapper;

import pl.nullpointerexception.mapping.controller.dto.PostTitleDto;
import pl.nullpointerexception.mapping.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostDtoMapper {

    public static List<PostTitleDto> mapPostToPostTitleDto(List<Post> posts) {
        return posts.stream()
                .map(post -> new PostTitleDto(post.getId(), post.getTitle()))
                .collect(Collectors.toList());
    }
}
