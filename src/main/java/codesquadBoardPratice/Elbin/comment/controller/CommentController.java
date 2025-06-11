package codesquadBoardPratice.Elbin.comment.controller;

import codesquadBoardPratice.Elbin.article.domain.Article;
import codesquadBoardPratice.Elbin.article.repository.ArticleRepository;
import codesquadBoardPratice.Elbin.comment.dto.request.CommentCreateDto;
import codesquadBoardPratice.Elbin.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final ArticleRepository articleRepository;

    @PostMapping("{id}")
    public ResponseEntity<Void> createComment(@RequestBody CommentCreateDto commentCreateDto, @PathVariable Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Article not found"));
        commentService.save(commentCreateDto, article);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
