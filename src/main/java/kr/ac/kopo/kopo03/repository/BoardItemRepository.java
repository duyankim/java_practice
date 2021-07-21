package kr.ac.kopo.kopo03.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo03.domain.BoardItem;

@Repository
public interface BoardItemRepository  extends JpaRepository<BoardItem, Integer>, JpaSpecificationExecutor<BoardItem>{
	BoardItem findFirstByOrderByIdDesc();
	List<BoardItem> findByTitleContaining(String keyword);
	Page<BoardItem> findByBoard_id(int board_id, Pageable pageable);
	List<BoardItem> findByBoard_id(int board_id);
	List<BoardItem> findByContentContainingIgnoreCase(String keyword);
}
