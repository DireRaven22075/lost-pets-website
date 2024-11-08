package team.ccnu.project.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="board_data")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;

    @Column(name="PST_TITLE", length=100)
    private String title;

    @Lob
    @Column(name="PST_CMT")
    private String content;


}
