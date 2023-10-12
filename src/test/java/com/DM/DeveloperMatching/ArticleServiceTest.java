package com.DM.DeveloperMatching.service;

import com.DM.DeveloperMatching.domain.Article;
import com.DM.DeveloperMatching.domain.User;
import com.DM.DeveloperMatching.dto.Article.AddArticleRequest;
import com.DM.DeveloperMatching.dto.Article.UpdateArticleRequest;
import com.DM.DeveloperMatching.repository.ArticleRepository;
import com.DM.DeveloperMatching.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ArticleServiceTest {

    @InjectMocks
    private ArticleService articleService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ArticleRepository articleRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveArticle() {
        AddArticleRequest request = new AddArticleRequest();
        // Mocking request setup for the sake of example
//        request.toEntity()

//        User user = new User();
        // Mocking user setup for the sake of example
        // ... setup other user fields if needed ...

//        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(articleRepository.save(any(Article.class))).thenAnswer(invocation -> invocation.getArgument(0));

        articleService.save(request, 1L);

        verify(userRepository, times(1)).findById(anyLong());
        verify(articleRepository, times(1)).save(any(Article.class));
    }

    @Test
    public void testUpdateArticle() {
        UpdateArticleRequest request = new UpdateArticleRequest();
        // Mocking request setup for the sake of example
//        request.setTitle("Updated Article");
        // ... setup other request fields if needed ...

//        Article article = new Article();
        // Mocking article setup for the sake of example
        // ... setup other article fields if needed ...

//        when(articleRepository.findById(anyLong())).thenReturn(Optional.of(article));
//
//        articleService.update(request, 1L);
//
//        verify(articleRepository, times(1)).findById(anyLong());
        // Optionally, you can verify that article attributes were updated as expected.
    }

    @Test
    public void testDeleteArticle() {
//        Article article = new Article();
        // Mocking article setup for the sake of example
        // ... setup other article fields if needed ...

//        when(articleRepository.findById(anyLong())).thenReturn(Optional.of(article));
//
//        articleService.delete(1L);
//
//        verify(articleRepository, times(1)).findById(anyLong());
        // Optionally, you can verify the delete or any other expected behavior.
    }

    // Optionally, you can add more tests, e.g., what happens if user or article is not found, etc.
}
