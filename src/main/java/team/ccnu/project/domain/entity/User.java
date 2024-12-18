package team.ccnu.project.domain.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import java.util.ArrayList;
import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Builder
@Entity
public class User {
    //PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_sn") private long sn;

    //FK
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    //FK
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    //DATA COLUMN
    @Column(name="user_id", length=50)
    private String id; //User ID
    @Column(name="user_salt", length=100)
    private String salt; //User Salt
    @Column(name="user_hash", length=256)
    private String pw; //User Password
    @Column(name="user_name", length=50)
    private String name; //User Nickname
    @Column(name="user_mail", length=100)
    private String email; //User EMail
    @Column(name="user_role") @ColumnDefault("'U'")
    private char role; //User Role (Admin, User, Block)
}