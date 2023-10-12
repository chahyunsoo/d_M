package com.DM.DeveloperMatching.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long pId;

    @Column(name = "member_count")
    private int memberCnt;

    @OneToOne(mappedBy = "project")
    private Article article;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_status")
    private ProjectStatus projectStatus;

    @OneToMany(mappedBy = "project") //양방향 잡을라고
    private List<Member> projectInMember = new ArrayList<>();

    @Builder
    public Project(int memberCnt,ProjectStatus projectStatus) {
        this.memberCnt = memberCnt;
        this.projectStatus = projectStatus;
    }


}
