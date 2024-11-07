package team.ccnu.project.domain.entity.board;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="board")
///<summary>
///</summary>
//게시판 엔티티
public class BoardEntity {
    @Id
    @Column(name="PST_SN")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;
}