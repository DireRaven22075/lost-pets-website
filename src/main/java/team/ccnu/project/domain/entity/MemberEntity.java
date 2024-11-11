package team.ccnu.project.domain.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@Entity
@Table(name = "member_main")
///<summary>
///member_main 테이블 내에 사용자를 받아오기 위한 Entity Class입니다.
///sn = MEM_SN (Member Singal)
///id = MEM_ID (Member ID)
///pw = MEM_PW (Member Password) EncryptTo(SHA-512)
///email = MEM_EMAIL (Member Email)
///name = MEM_NAME (Member Name)
///</summary>
public class MemberEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MEM_SN")
    private Long sn;
    
    @Column(name="MEM_ID", nullable=false)
    @ColumnDefault("Nil")
    private String id;

	@Column(name="MEM_PW", nullable=false)
    @ColumnDefault("Nil")
    private String pw;

	@Column(name="MEM_EMAIL", nullable=false)
    @ColumnDefault("Nil")
    private String email;

    @Column(name="MEM_NAME", nullable = false)
    @ColumnDefault("Nil")
    private String name;

    @Column(name="MEM_ICON", nullable=false)
    @ColumnDefault("Nil")
    private String icon;
    
    @Column(name="MEM_UID", nullable=false)
    @ColumnDefault("Nil")
    private String uid;
}