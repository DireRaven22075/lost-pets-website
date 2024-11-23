package team.ccnu.project.data.request;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadPostDTO {
    private String title;
    private String content;
}
