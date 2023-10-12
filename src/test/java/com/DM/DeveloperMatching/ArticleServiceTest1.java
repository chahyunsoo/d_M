package com.DM.DeveloperMatching;

import com.DM.DeveloperMatching.domain.Article;
import com.DM.DeveloperMatching.domain.Level;
import com.DM.DeveloperMatching.domain.User;
import com.DM.DeveloperMatching.dto.Article.AddArticleRequest;
import com.DM.DeveloperMatching.repository.ArticleRepository;
import com.DM.DeveloperMatching.repository.UserRepository;
import com.DM.DeveloperMatching.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ArticleServiceTest1 {
    @Autowired ArticleService articleService;
    @Autowired private UserRepository userRepository;
    @Autowired private ArticleRepository articleRepository;
    @Test
    public void articleServiceTest () throws Exception {
        //given
        User user = User.builder().userName("cha").level(Level.JUNIOR).point(1.0).part("BackEnd").introduction("hello")
                .password("1234").career("no career").phoneNum("000-000").build();

        Article article = new AddArticleRequest().toEntity(user);


//        articleService.save(addArticleRequest, user.getUId());


        //when

        //then

    }
}


