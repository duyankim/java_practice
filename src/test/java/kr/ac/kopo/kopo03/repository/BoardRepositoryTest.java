package kr.ac.kopo.kopo03.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo03.domain.Board;
import kr.ac.kopo.kopo03.repository.BoardRepository;

@SpringBootTest
class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepository;
	 
	@Test
	public void findById() throws Exception{
		Board b1 = new Board();
		b1.setTitle("hello");
		boardRepository.save(b1);
		
		Board result = boardRepository.findById(4).get();
		assertThat(result).isEqualTo(b1);
	}
}
