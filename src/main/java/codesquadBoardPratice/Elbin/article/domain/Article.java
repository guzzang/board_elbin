package codesquadBoardPratice.Elbin.article.domain;

import codesquadBoardPratice.Elbin.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Article {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    private String title;

    private String content;

    public Article(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public void update(String content) {
        this.content = content;
    }
}
