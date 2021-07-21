package kr.ac.kopo.kopo03.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo03.domain.BoardItem;
import kr.ac.kopo.kopo03.repository.BoardItemRepository;

@Service
public class BoardItemServiceImpl implements BoardItemService{
	
	private final BoardItemRepository boardItemRepository;
	
	public BoardItemServiceImpl(BoardItemRepository boardItemRepository) {
		this.boardItemRepository = boardItemRepository;
	}

	@Override
	@Transactional
	public void create(BoardItem boardItem) {
		boardItemRepository.save(boardItem);
	}

	@Override
	@Transactional
	public void delete(BoardItem boardItem) {
		boardItemRepository.delete(boardItem);
	}

	@Override
	@Transactional
	public Optional<BoardItem> viewOne(int post_id) {
		Optional<BoardItem> b = boardItemRepository.findById(post_id);
		return b;
	}

	@Override
	@Transactional
	public List<BoardItem> viewAll() {
		return boardItemRepository.findAll();
	}

	@Override
	@Transactional
	public List<BoardItem> viewAllInOneBoard(int board_id) {
		return boardItemRepository.findByBoard_id(board_id);
	}

	@Override
	@Transactional
	public List<BoardItem> viewOnePageResult(int board_id, Integer page) {
		PageRequest pageRequest = PageRequest.of(page, 5);
		return boardItemRepository.findByBoard_id(board_id, pageRequest).getContent();
	}

	@Override
	@Transactional
	public int newPostId() {
		int lastId = boardItemRepository.findFirstByOrderByIdDesc().getId();
		return lastId+1;
	}

	@Override
	@Transactional
	public List<BoardItem> viewAllSearchResult(String keyword) {
		return boardItemRepository.findByContentContainingIgnoreCase(keyword);
	}

}
