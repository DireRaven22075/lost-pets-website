package team.ccnu.project.data.response;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {
    private Long owner;
    private String title;
    private String content;
    private Long view;
    private Long liked;
}
