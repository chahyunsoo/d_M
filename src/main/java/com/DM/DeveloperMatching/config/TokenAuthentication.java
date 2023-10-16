package com.DM.DeveloperMatching.config;

import com.DM.DeveloperMatching.config.jwt.JwtTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class TokenAuthentication extends OncePerRequestFilter {

    private JwtTokenProvider jwtTokenProvider;
    private final static String HEADER_AUTHORIZATION = "Authorization";
    private final static String TOKEN_PREFIX = "Bearer ";


    // HTTP 요청이 들어올 때마다 실행함
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //HTTP요청 헤더에 'Authorization' 키의 값을 가져옴
        String authorizationHeader = request.getHeader(HEADER_AUTHORIZATION);

        //가져온 값에서 'Bearer'접두사 제거하고 token에 저장
        String token = removeBearer(authorizationHeader);

        //가져온 토큰이 유효한지 확인 후, 유효하면 인증 정보를 설정
        if (jwtTokenProvider.validToken(token)) {
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication); //인증 정보를 'SecurityContextHolder'에 설정함
        }

        filterChain.doFilter(request, response); //필터 처리가 끝났기 때문에, 필터 체인의 다음 필터로 요청과 응답을 전송함
    }

    // 'Authorization' 헤더에서 'Bearer' 접두사를 제거하는 메소드 정의
    private String removeBearer(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFIX)) {
            return authorizationHeader.substring(TOKEN_PREFIX.length());
        }
        return null;
    }


}
