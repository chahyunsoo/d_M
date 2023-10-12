package com.DM.DeveloperMatching.controller;

import com.DM.DeveloperMatching.domain.Article;
import com.DM.DeveloperMatching.dto.Article.AddArticleRequest;
import com.DM.DeveloperMatching.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class ArticleController {
    private final ArticleService articleService;

    //Article 생성
//    @PostMapping("/articles")
//    public ResponseEntity<Article> createArticle(@RequestBody AddArticleRequest addArticleRequest) {
//        Long uId;
//
//        Article savedArticle = articleService.save(addArticleRequest,uId);
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(savedArticle);
//    }

    //Article 수정
//    @PutMapping("/articles/")
//    public Article update()

}
