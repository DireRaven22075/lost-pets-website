package team.ccnu.project.domain.entity;

/*
 * 회원 정보를 담는 Entity
 * - name : 회원 이름
 * - memberID : 회원 ID
 * - password : 회원 비밀번호
 * - email : 회원 이메일
 */


import jakarta.persistence.*;

@lombok.Getter
@lombok.NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MEM_SN")
    private Long sn;
    @Column(name="MEM_ID", nullable=false)
    private String id;
	@Column(name="MEM_PW", nullable=false)
    private String pw;
	@Column(name="MEM_EMAIL", nullable=false)
    private String email;
    @Column(name="MEM_NAME", nullable = false)
    private String name;
    @Column(name="MEM_UID", nullable=false)
    private String uid;
}