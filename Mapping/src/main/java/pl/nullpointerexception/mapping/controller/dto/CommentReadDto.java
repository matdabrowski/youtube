package pl.nullpointerexception.mapping.controller.dto;

public class CommentReadDto {
    private Long id;
    private String content;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public static final class CommentReadDtoBuilder {
        private Long id;
        private String content;

        private CommentReadDtoBuilder() {
        }

        public static CommentReadDtoBuilder aCommentReadDto() {
            return new CommentReadDtoBuilder();
        }

        public CommentReadDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CommentReadDtoBuilder withContent(String content) {
            this.content = content;
            return this;
        }

        public CommentReadDto build() {
            CommentReadDto commentReadDto = new CommentReadDto();
            commentReadDto.id = this.id;
            commentReadDto.content = this.content;
            return commentReadDto;
        }
    }
}
