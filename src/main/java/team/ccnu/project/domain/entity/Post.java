package team.ccnu.project.domain.entity;

import java.util.LinkedList;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

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
    
    // 게시판 ID
    private Long boardId;
}
