package pl.nullpointerexception.mapping.controller.mapper;

import pl.nullpointerexception.mapping.controller.dto.PostDto;
import pl.nullpointerexception.mapping.model.Post;

public class PostMapper {

    public static Post mapToPost(long id, PostDto postDto) {
        return Post.PostBuilder.aPost()
                .withId(id)
                .withTitle(postDto.title())
                .withContent(postDto.content())
                .build();
    }
}
