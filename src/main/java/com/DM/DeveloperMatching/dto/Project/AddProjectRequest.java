package com.DM.DeveloperMatching.dto.Project;

import com.DM.DeveloperMatching.domain.Article;
import com.DM.DeveloperMatching.domain.Project;
import com.DM.DeveloperMatching.domain.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddProjectRequest {
    private Long pId;
    private int memberCnt;
    private Article article;
    private ProjectStatus projectStatus;

    public Project toEntity(Article article) {
        return Project.builder()
                .memberCnt(memberCnt)
                .projectStatus(projectStatus)
                .build();
    }
}
