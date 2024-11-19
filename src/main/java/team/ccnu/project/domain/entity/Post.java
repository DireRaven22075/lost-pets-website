package team.ccnu.project.domain.entity;

import java.util.LinkedList;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@Entity
public class Post {
    //PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sn")
    private long sn;

    @Column(name="id")
    private int id;
    //FK
    @OneToMany
    private LinkedList<File> files = new LinkedList<>();

    //DATA COLUMN
    private String title;
    @Lob private String content;
    @ColumnDefault("0") private Long view;
    @ColumnDefault("0") private Long like;
}
