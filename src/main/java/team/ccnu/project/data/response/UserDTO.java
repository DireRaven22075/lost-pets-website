package team.ccnu.project.data.response;

import team.ccnu.project.domain.entity.User;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long sn;
    private String id;
    private String name;
    private String mail;

    public UserDTO(User user) {
        this.sn = user.getSn();
        this.id = user.getId();
        this.name = user.getName();
        this.mail = user.getEmail();
    }
}
