package team.ccnu.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.ccnu.project.domain.entity.MemberEntity;
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByName(String name);
    MemberEntity findByEmail(String email);
    MemberEntity findById(String id);
    void deleteById(String id);
}