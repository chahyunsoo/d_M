package com.DM.DeveloperMatching.service;

import com.DM.DeveloperMatching.domain.Article;
import com.DM.DeveloperMatching.domain.Project;
import com.DM.DeveloperMatching.domain.User;
import com.DM.DeveloperMatching.dto.Project.AddProjectRequest;
import com.DM.DeveloperMatching.repository.ArticleRepository;
import com.DM.DeveloperMatching.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 내 프로젝트 조회하기
 * 추천 프로젝트 조회하기
 * 지원할 프로젝트 조회하기
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ArticleRepository articleRepository;

    //프로젝트 생성
    public Project save(AddProjectRequest addProjectRequest, Long aId) {
        Article findArticle = articleRepository.findById(aId).orElseThrow(() -> new IllegalArgumentException("not found user"));

        return projectRepository.save(addProjectRequest.toEntity(findArticle));
    }

    //프로젝트 수정
//    public void update()


}
