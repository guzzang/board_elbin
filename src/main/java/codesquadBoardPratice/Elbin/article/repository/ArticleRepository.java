package codesquadBoardPratice.Elbin.article.repository;

import codesquadBoardPratice.Elbin.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
