package team.ccnu.project.data.request;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDTO {
    private String key;
    private String value;
}
