package team.ccnu.project.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import lombok.Builder;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    //PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sn")
    private long sn;

    //FK
    
    //DATA COLUMN
    // User ID
    private String id;
    // User Password
    private String pw;
    // User Name
    private String name;
    // Email Address
    private String email;

    @ColumnDefault("'U'")
    private char role;
}