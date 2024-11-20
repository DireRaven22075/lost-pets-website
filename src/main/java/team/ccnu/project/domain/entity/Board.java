package team.ccnu.project.domain.entity;

import java.util.LinkedList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@Entity
/// <summary>
/// Board Entity Class
/// sn : PK
/// posts : FK to Post
/// </summary>
public class Board {
    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sn;
    //FK
    @OneToMany
    private LinkedList<Post> posts = new LinkedList<>();
    //DATA COLUMN
}
