package com.DM.DeveloperMatching.service;

import com.DM.DeveloperMatching.dto.Article.UpdateArticleRequest;
import org.springframework.stereotype.Service;
import com.DM.DeveloperMatching.domain.Article;
import com.DM.DeveloperMatching.domain.User;
import com.DM.DeveloperMatching.dto.Article.AddArticleRequest;
import com.DM.DeveloperMatching.repository.ArticleRepository;
import com.DM.DeveloperMatching.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 프로젝트 등록하기
 * 프로젝트 수정하기
 * 프로젝트 조회하기->팀장 입장에서 -> 프로젝트 팀원 관리하기
 */
@RequiredArgsConstructor
@Service
@Transactional
public class ArticleService {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    //모집 글 생성
    public Article save(AddArticleRequest articleRequest, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("not found user"));

        return articleRepository.save(articleRequest.toEntity(user));
    }

    //모집 글 수정
    public void update(UpdateArticleRequest updateArticleRequest,Long articleId) {
        Article findArticle = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("not found user"));

        findArticle.update(updateArticleRequest.getArticleOwner(), updateArticleRequest.getTitle(),
                updateArticleRequest.getMaximumMember(), updateArticleRequest.getRecPart(),
                updateArticleRequest.getRecTech(), updateArticleRequest.getRecLevel(),
                updateArticleRequest.getDuring(), updateArticleRequest.getDue(),
                updateArticleRequest.getContent(), updateArticleRequest.getProjectImg()
        );
    }

    //모집 글 삭제
    public void delete(Long articleId) {
//        Article findArticle = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("not found user"));
//        articleRepository.delete(findArticle);
        articleRepository.findById(articleId);
    }

    //모집 글 조회 -> 팀장 입장에서 프로젝트 팀원 관리하기
//    public List<Article> findArticle() {
//        return articleRepository.findAll();
//    }

}