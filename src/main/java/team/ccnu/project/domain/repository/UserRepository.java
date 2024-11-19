package team.ccnu.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.ccnu.project.domain.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    User findByEmail(String email);

    User findByIdAndPw(String id, String pw);
    User findById(String id);
    User findBySn(Long sn);
    void deleteBySn(Long sn);
}