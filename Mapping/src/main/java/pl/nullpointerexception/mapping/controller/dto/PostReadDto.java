package pl.nullpointerexception.mapping.controller.dto;

import java.util.List;

public class PostReadDto {
    private Long id;
    private String title;
    private String content;
    private List<CommentReadDto> comments;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<CommentReadDto> getComments() {
        return comments;
    }

    public static final class PostReadDtoBuilder {
        private Long id;
        private String title;
        private String content;
        private List<CommentReadDto> comments;

        private PostReadDtoBuilder() {
        }

        public static PostReadDtoBuilder aPostReadDto() {
            return new PostReadDtoBuilder();
        }

        public PostReadDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PostReadDtoBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public PostReadDtoBuilder withContent(String content) {
            this.content = content;
            return this;
        }

        public PostReadDtoBuilder withComments(List<CommentReadDto> comments) {
            this.comments = comments;
            return this;
        }

        public PostReadDto build() {
            PostReadDto postReadDto = new PostReadDto();
            postReadDto.title = this.title;
            postReadDto.comments = this.comments;
            postReadDto.id = this.id;
            postReadDto.content = this.content;
            return postReadDto;
        }
    }
}
