package team.ccnu.project.domain.entity;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Builder
@Entity
public class Post {
    // 기본 키
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sn")
    private long sn; // 게시글 ID

    // 외래 키
    @ManyToOne
    private User owner; // 작성자

    // 외래 키
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> files = new LinkedList<>(); // 이미지 파일 목록

    // 데이터 컬럼
    private Long uid; // 게시판 ID
    private String title; // 제목
    @Lob private String content; // 내용
    @ColumnDefault("0") private Long view; // 조회수
    @ColumnDefault("'Y'")
    private char status; // 상태 (입양 여부)

    @Column(name="ImagePath_1")
    private String imagePath_1; // 이미지 경로 1

    @Column(name="ImagePath_2")
    private String imagePath_2; // 이미지 경로 2

    @Column(name="ImagePath_3")
    private String imagePath_3; // 이미지 경로 3

    // 이미지 파일 추가 메서드
    public void addFile(Image image) {
        files.add(image);
        image.setPost(this);
    }
}
