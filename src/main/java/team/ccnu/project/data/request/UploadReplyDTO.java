package team.ccnu.project.data.request;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadReplyDTO {
    private String content;
    private Long parentCommentSn;
}