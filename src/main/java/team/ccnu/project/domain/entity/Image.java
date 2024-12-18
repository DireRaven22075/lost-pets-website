package team.ccnu.project.domain.entity;


import jakarta.persistence.*;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Builder
@Entity
public class Image {
    //PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="file_sn")
    private Long sn;
    //FK
    @ManyToOne
    @JoinColumn(name="post_sn")
    private Post post;
    //DATA COLUMN
    @Column(name="file_path", columnDefinition="TEXT")
    private String path;
}
