package team.ccnu.project.data.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.domain.entity.User;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
    private String content;
    private User owner;
    private Post post;
}
