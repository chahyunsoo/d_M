package com.DM.DeveloperMatching.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 자동으로 1씩 증가함
    @Column(name = "user_id")
    private Long uId;

    @Column(name = "user_name",nullable = false)
    private String userName;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "phone_num",nullable = false)
    private String phoneNum;

    @Column(name = "part",nullable = false) //파트
    private String part;

    @Enumerated(EnumType.STRING)
    @Column(name = "level",nullable = false)
    private Level level;

    @Column(name = "point")
    private Double point; //double은 null타입을 가질 수 없으니까 double로..

    @Column(name = "introduction", length = 100)
    private String introduction;

    @Column(name = "career")
    private String career;

    @Column(name = "recStack") //기술 스택
    private List<String> recStack = new ArrayList<>();

    @OneToMany(mappedBy = "articleOwner")
    private List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)   //양방향 잡을라고
    private List<Member> userInMember = new ArrayList<>();

    @OneToMany
    private List<Likes> likes = new ArrayList<>();


    /**
     * User 수정
     * 그런데 level이랑 point를 자기가 수정하게 할 수는 없으니까 빼야겠지?
     */
    public void updateUser(String userName, String password, String phoneNum, String part, Level level
            , Double point, String introduction, String career,List<String> recStack) {
        this.userName = userName;
        this.password = password;
        this.phoneNum = phoneNum;
        this.part = part;
        this.level = level;
        this.point = point;
        this.introduction = introduction;
        this.career = career;
        this.recStack = new ArrayList<>();
    }

    @Builder
    public User(String userName, String password, String phoneNum, String part, Level level, Double point, String introduction, String career) {
        this.userName = userName;
        this.password = password;
        this.phoneNum = phoneNum;
        this.part = part;
        this.level = level;
        this.point = point;
        this.introduction = introduction;
        this.career = career;
    }




}
