package team.ccnu.project.domain.entity;

import jakarta.persistence.*;

import java.util.LinkedList;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@Entity
@Table(name="user_main")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sn;



    @OneToMany
    private LinkedList<Post> posts = new LinkedList<>();

}
