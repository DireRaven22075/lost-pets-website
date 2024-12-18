package team.ccnu.project.data.request;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class UploadReplyDTO {
    private Long pst;
    private Long cmnt;
    private String text;
}
