package kr.ac.kopo.kopo03.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.ac.kopo.kopo03.domain.Board;
import kr.ac.kopo.kopo03.domain.BoardItem;

@SpringBootTest
class BoardItemRepositoryTest {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private BoardItemRepository boardItemRepository;
	
//	@Test
	void create() {
		Board board1 = new Board();
		board1.setTitle("title1");
		
		BoardItem boardItem1 = new BoardItem();
		boardItem1.setTitle("boardItem1");
		boardItem1.setBoard(board1);
		
		BoardItem boardItem2 = new BoardItem();
		boardItem2.setTitle("boardItem2");
		boardItem2.setBoard(board1);
		
		List<BoardItem> list = new ArrayList<>();
		list.add(boardItem1);
		list.add(boardItem2);
		
		board1.setBoardItems(list);
		
		boardRepository.save(board1);
	}
	
//	@Transactional
//	@Test
	void selectAll1() {
		Optional<Board> boardOptional = boardRepository.findById(1);
		if (boardOptional.isPresent()) {
			Board board = boardOptional.get();
			Hibernate.initialize(board.getBoardItems());
			System.out.println(board.getTitle());
		}
	}
	
//	@Test
	void selectAll2() {
		List<BoardItem> boardItems = boardItemRepository.findAll();
		for(BoardItem boardItem: boardItems) {
			System.out.println(boardItem.getTitle());
		}
	}
	
//	@Test
	void selectOne1() {
		Optional<Board> boardOptional = boardRepository.findById(3);
		if (boardOptional.isPresent()) {
			Board board = boardOptional.get();
			System.out.println(board.getTitle());
		}
	}
	
	@Test
	void deleteOne() {
		boardRepository.deleteById(1);
	}
	
	
//	@Test
	void findById() {
		BoardItem item1 = new BoardItem();
		item1.setTitle("test data");
		item1.setId(100);
		BoardItem result = boardItemRepository.findById(100).get();
		assertThat(result).isEqualTo(item1);
	}
	
//	@Test
	void deleteById() {
		Board board1 = new Board();
		BoardItem boardItem1 = new BoardItem();
		boardItem1.setTitle("boardItem1");
		boardItem1.setBoard(board1);
		
		boardRepository.delete(board1);
	}
}
