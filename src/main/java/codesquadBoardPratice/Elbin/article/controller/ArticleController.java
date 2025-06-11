package codesquadBoardPratice.Elbin.article.controller;

import codesquadBoardPratice.Elbin.article.dto.request.ArticleCreateDto;
import codesquadBoardPratice.Elbin.article.dto.request.ArticleUpdateDto;
import codesquadBoardPratice.Elbin.article.service.ArticleService;
import codesquadBoardPratice.Elbin.user.domain.User;
import codesquadBoardPratice.Elbin.web.SessionConst;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("")
    public ResponseEntity<Void> createArticle(@RequestBody ArticleCreateDto articleCreateDto) {
        articleService.save(articleCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateArticle(@PathVariable Long id, @RequestBody ArticleUpdateDto articleUpdateDto, HttpSession session) throws AccessDeniedException {
        User user = (User) session.getAttribute(SessionConst.LOGIN_MEMBER);

        articleService.update(id, user, articleUpdateDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id, HttpSession session) throws AccessDeniedException {
        User user = (User) session.getAttribute(SessionConst.LOGIN_MEMBER);

        articleService.deleteById(id, user);
        return ResponseEntity.ok().build();
    }






}
