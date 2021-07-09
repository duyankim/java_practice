package kr.ac.kopo.kopo03.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
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
	public void create(BoardItem boardItem) {
		boardItemRepository.save(boardItem);
	}

	@Override
	public void delete(BoardItem boardItem) {
		boardItemRepository.delete(boardItem);
	}

	@Override
	public Optional<BoardItem> viewOne(int post_id) {
		Optional<BoardItem> b = boardItemRepository.findById(post_id);
		return b;
	}

	@Override
	public List<BoardItem> viewAll() {
		return boardItemRepository.findAll();
	}

	@Override
	public List<BoardItem> viewOnePageResult(int board_id, Integer page, Integer size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		return boardItemRepository.findByBoard(board_id, pageRequest).getContent();
	}

	@Override
	public String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}

	@Override
	public int newPostId() {
		int lastId = boardItemRepository.findFirstByOrderByIdDesc().getId();
		return lastId+1;
	}
}
