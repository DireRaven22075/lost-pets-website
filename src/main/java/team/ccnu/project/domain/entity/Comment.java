package team.ccnu.project.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@Entity
public class Comment {
    //PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sn;
    //FK
    @ManyToOne
    private Post post;
    //FK
    @ManyToOne
    private User user;

    //DATA COLUMN
    private String text;
}
