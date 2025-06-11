package codesquadBoardPratice.Elbin.comment.domain;

import codesquadBoardPratice.Elbin.article.domain.Article;
import codesquadBoardPratice.Elbin.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Article article;

    private String content;

    public Comment(User user, Article article, String content) {
        this.user = user;
        this.article = article;
        this.content = content;
    }
}
