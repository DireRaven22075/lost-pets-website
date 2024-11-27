package team.ccnu.project.data.response;

import lombok.*;
import team.ccnu.project.domain.entity.Post;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {
    private Long owner; // User ID
    private String title;
    private String content;
    private Long view;


    // Post 엔티티를 기반으로 하는 생성자 추가
    public PostDTO(Post post) {
        this.owner = post.getOwner().getSn(); // User 객체의 ID를 사용
        this.title = post.getTitle();
        this.content = post.getContent();
        this.view = post.getView();
    }
}
