package pl.nullpointerexception.mapping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public static final class PostBuilder {
        private Post post;

        private PostBuilder() {
            post = new Post();
        }

        public static PostBuilder aPost() {
            return new PostBuilder();
        }

        public PostBuilder withId(Long id) {
            post.setId(id);
            return this;
        }

        public PostBuilder withTitle(String title) {
            post.setTitle(title);
            return this;
        }

        public PostBuilder withContent(String content) {
            post.setContent(content);
            return this;
        }

        public PostBuilder withComments(List<Comment> comments) {
            post.setComments(comments);
            return this;
        }

        public Post build() {
            return post;
        }
    }
}
