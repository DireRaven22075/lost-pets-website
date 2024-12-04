package team.ccnu.project.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Builder
@Entity
public class Image {
    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;
    //FK
    @ManyToOne
    private Post post;
    //DATA COLUMN
    private String path;
}
