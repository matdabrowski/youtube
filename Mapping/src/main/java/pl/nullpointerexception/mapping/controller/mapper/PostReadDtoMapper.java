package pl.nullpointerexception.mapping.controller.mapper;

import pl.nullpointerexception.mapping.controller.dto.CommentReadDto;
import pl.nullpointerexception.mapping.controller.dto.PostReadDto;
import pl.nullpointerexception.mapping.model.Comment;
import pl.nullpointerexception.mapping.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostReadDtoMapper {

    public static List<PostReadDto> mapPostToPostReadDtoList(List<Post> posts) {
        return posts.stream()
                .map(post -> mapPostToDto(post))
                .collect(Collectors.toList());
    }

    private static PostReadDto mapPostToDto(Post post) {
        return PostReadDto.PostReadDtoBuilder.aPostReadDto()
                .withId(post.getId())
                .withTitle(post.getTitle())
                .withContent(post.getContent())
                .withComments(mapCommentToDtos(post))
                .build();
    }

    private static List<CommentReadDto> mapCommentToDtos(Post post) {
        return post.getComments().stream()
                .map(comment -> mapCommentToDto(comment))
                .collect(Collectors.toList());
    }

    private static CommentReadDto mapCommentToDto(Comment comment) {
        return CommentReadDto.CommentReadDtoBuilder.aCommentReadDto()
                .withId(comment.getId())
                .withContent(comment.getContent())
                .build();
    }
}
