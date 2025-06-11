package codesquadBoardPratice.Elbin.article.service;

import codesquadBoardPratice.Elbin.article.domain.Article;
import codesquadBoardPratice.Elbin.article.dto.request.ArticleCreateDto;
import codesquadBoardPratice.Elbin.article.dto.request.ArticleUpdateDto;
import codesquadBoardPratice.Elbin.article.repository.ArticleRepository;
import codesquadBoardPratice.Elbin.comment.repository.CommentRepository;
import codesquadBoardPratice.Elbin.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.AccessDeniedException;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public void save(ArticleCreateDto articleCreateDto) {
        articleRepository.save(new Article(null, articleCreateDto.getTitle(), articleCreateDto.getContent()));
    }

    @Transactional
    public void deleteById(Long id, User user) throws AccessDeniedException {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Article not found"));

        if(!article.getUser().getId().equals(user.getId())) {
            throw new AccessDeniedException("본인의 글만 삭제할 수 있습니다.");
        }

        commentRepository.deleteByArticleId(id);
        articleRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, User user, ArticleUpdateDto articleUpdateDto) throws AccessDeniedException {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Article not found"));

        if(!article.getUser().getId().equals(user.getId())) {
            throw new AccessDeniedException("본인의 글만 수정할 수 있습니다.");
        }

        article.update(articleUpdateDto.getContent());
    }
}
