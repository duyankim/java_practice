package kr.ac.kopo.kopo03.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo03.domain.BoardItem;

@Service
public interface BoardItemService {
	void create(BoardItem boardItem);
	void delete(BoardItem boardItem);
	Optional<BoardItem> viewOne(int post_id);
	List<BoardItem> viewAll();
	List<BoardItem> viewAllInOneBoard(int board_id);
	List<BoardItem> viewOnePageResult(int board_id, Integer page);
	List<BoardItem> viewAllSearchResult(String keyword);
	int newPostId();
}
