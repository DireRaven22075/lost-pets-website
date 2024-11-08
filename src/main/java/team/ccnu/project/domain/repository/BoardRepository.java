package team.ccnu.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.ccnu.project.domain.entity.board.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
