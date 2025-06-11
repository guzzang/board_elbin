package codesquadBoardPratice.Elbin.comment.service;

import codesquadBoardPratice.Elbin.article.domain.Article;
import codesquadBoardPratice.Elbin.comment.domain.Comment;
import codesquadBoardPratice.Elbin.comment.dto.request.CommentCreateDto;
import codesquadBoardPratice.Elbin.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public void save(CommentCreateDto commentCreateDto, Article article) {
        commentRepository.save(new Comment(null, article, commentCreateDto.getContent()));
    }
}
