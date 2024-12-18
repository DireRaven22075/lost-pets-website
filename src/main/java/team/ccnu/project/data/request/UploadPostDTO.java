package team.ccnu.project.data.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadPostDTO {
    private String title;
    private String content;
    private char status;
    private Long uid;
    private List<MultipartFile> files;
}
