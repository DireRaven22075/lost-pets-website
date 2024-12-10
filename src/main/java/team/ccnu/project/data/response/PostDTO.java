package team.ccnu.project.data.response;

import lombok.*;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.domain.entity.User;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    //Public Variables
    private Long sn;
    private String title;
    private String content;
    private Long view;
    private char status = 'Y';

    //System Variables
    private User owner; // User ID


    // Post 엔티티를 기반으로 하는 생성자 추가
    public PostDTO(Post post) {
        this.owner = post.getOwner();
        this.sn = post.getSn();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.view = post.getView();
    }
}
