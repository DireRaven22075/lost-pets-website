package team.ccnu.project.domain.entity.board;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import team.ccnu.project.domain.entity.MemberEntity;

import java.sql.Timestamp;
import java.util.LinkedList;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="board_main")
/// <summary>
///
///
/// </summary>
public class BoardEntity {
    @Id
    @Column(name="BBS_SN")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;
    @OneToMany
    @
    private LinkedList<PostEntity> posts = new LinkedList<>();
    @CreationTimestamp
    private Timestamp time;
}