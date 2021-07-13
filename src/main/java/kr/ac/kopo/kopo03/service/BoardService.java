package kr.ac.kopo.kopo03.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo03.domain.Board;

@Service
public interface BoardService {
    void create(Board board);
    void update(Board board);
    void delete(Board board);
    Optional<Board> viewOne(int id);
    List<Board> viewAll();
}
