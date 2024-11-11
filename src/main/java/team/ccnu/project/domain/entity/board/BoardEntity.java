package team.ccnu.project.domain.entity.board;

import java.sql.Timestamp;
import java.util.LinkedList;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private LinkedList<PostEntity> posts = new LinkedList<>();
    @CreationTimestamp
    private Timestamp time;
}