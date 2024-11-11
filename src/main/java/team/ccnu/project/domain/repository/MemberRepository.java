package team.ccnu.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.ccnu.project.domain.entity.MemberEntity;
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByName(String name);
    MemberEntity findByEmail(String email);
    MemberEntity findById(String id);
    MemberEntity findBySn(Long sn);
    void deleteById(String id);
}