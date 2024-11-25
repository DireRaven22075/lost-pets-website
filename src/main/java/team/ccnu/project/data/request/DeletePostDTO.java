package team.ccnu.project.data.request;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeletePostDTO {
    private Long postSn;
}
