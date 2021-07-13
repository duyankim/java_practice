package kr.ac.kopo.kopo03.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo03.domain.Board;
import kr.ac.kopo.kopo03.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{

	private final BoardRepository boardRepository;
	
	public BoardServiceImpl(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	@Override
	public void create(Board board) {
		boardRepository.save(board);
	}

	@Override
	public void update(Board board) {
		boardRepository.save(board);
	}

	@Override
	public void delete(Board board) {
		boardRepository.delete(board);
	}

	@Override
	public Optional<Board> viewOne(int id) {
		Optional<Board> b = boardRepository.findById(id);
		return b;
	}

	@Override
	public List<Board> viewAll() {
		return boardRepository.findAll();
	}

}
